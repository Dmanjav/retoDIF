package mx.itesm.difoodame.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.difoodame.model.ComidasMenu
import mx.itesm.difoodame.model.Encuesta
import mx.itesm.difoodame.model.ListaComedoresAPI
import mx.itesm.difoodame.model.RegistrarEncuesta
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
/**
 * @author Andrés Iván Rodríguez Méndez
 * Esta es el ViewModel y se hace la llamada a la API
 */


class EncuestaVM : ViewModel()
{

    val permitir = MutableLiveData<String?>()
    val idPedido = MutableLiveData<Int?>()

    private val retrofit by lazy {
        Retrofit.Builder()
            //.baseUrl("http://difood.ddns.net:5000/")
            .baseUrl("https://difood.ddns.net/")
            .addConverterFactory(GsonConverterFactory.create())  // JSON
            .build()
    }

    private val descargarComidas by lazy {
        retrofit.create(ComidasMenu::class.java)
    }
    private val descargarAPI by lazy {
        retrofit.create(ListaComedoresAPI::class.java)
    }

    fun getPedidos(endpoint: String){
         val apiService = retrofit.create(RegistrarEncuesta::class.java)

        val call = apiService.obtenerPedido(endpoint)

        call.enqueue(object : Callback<Map<String,Map<String,String>>>{

            override fun onResponse(
                call: Call<Map<String, Map<String, String>>>,
                response: Response<Map<String, Map<String, String>>>
            ) {
                if(response.isSuccessful){
                    Log.d("API_TEST_ENCUESTA", "SUCCESSFUL")
                    Log.d("API_TEST_ENCUESTA", "${response.body()}")
                    permitir.value="BIEN"

                    response.body()?.forEach { t, u ->
                        idPedido.value= t.toInt()
                        Log.d("API_TEST", "VALORER del ID PEDIDO ${t}")
                    }

                }
                else{
                    Log.d("API_TEST_ENCUESTA", "NO SUCCESSFUL, No hay pedidos")
                    permitir.value="MAL"
                    idPedido.value = null
                }
            }

            override fun onFailure(call: Call<Map<String, Map<String, String>>>, t: Throwable) {
                Log.d("API_TEST_ENCUESTA", "Error en la conexion con el servidor")
            }

        })
    }

    fun registrarEncuesta(encuesta: Encuesta){

        val apiService = retrofit.create(RegistrarEncuesta::class.java)
        // Se crea el Objeto Encuesta
        val call = apiService.registrarEncuesta(encuesta)

        call.enqueue(object : Callback<String> {


            override fun onResponse(call: Call<String>, response: Response<String>) {
                Log.d("API_TEST_ENCUESTA", "ENCUESTA NO REGISTRADA")
                permitir.value = response.body()
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.d("API_TEST_ENCUESTA", "ENCUESTA REGISTRADA")
                permitir.value = null
            }

        })
    }


}