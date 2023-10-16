package mx.itesm.difoodame.viewmodel

import android.telecom.CallEndpoint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.difoodame.model.Comedor
import mx.itesm.difoodame.model.ComidasMenu
import mx.itesm.difoodame.model.ListaComedoresAPI
import mx.itesm.difoodame.model.TokenResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MenuComidaVM : ViewModel()
{
    // Variables globales que puede consultar su valor el VIEW
    var comedor = MutableLiveData<Map<String, Int>>()
    var menu = MutableLiveData<Map<String, String>>()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://difood.ddns.net:5000/")
            //.baseUrl("https://difood.ddns.net/")
            .addConverterFactory(GsonConverterFactory.create())  // JSON
            .build()
    }

    // Se crean variables para decargar las listas
    private val descargarAPI by lazy {
        retrofit.create(ListaComedoresAPI::class.java)
    }
    private val descargarComidas by lazy {
        retrofit.create(ComidasMenu::class.java)
    }


    fun descargarComedores(endpoint: String)
    {
        val call = descargarAPI.descargarComedores(endpoint)

        call.enqueue(object : Callback<Map<String,Int>> {
            override fun onResponse(call: Call<Map<String, Int>>, response: Response<Map<String, Int>>
            )
            {
                if (response.isSuccessful){
                    // Si recibe los valores correctos se guarda en la variable comedor el diccionario de comedores
                    comedor.value = response.body()
                } else {
                    // Si no se recibe los valores correctos se arroja un mensaje en logcat
                    Log.d("API_TEST_COMEDORES", "FALLO EN OBTENER COMEDORES")
                }
            }

            override fun onFailure(call: Call<Map<String, Int>>, t: Throwable) {
                Log.d("API_TEST_COMEDORES", "FALLO EN CONEXION")
            }

        })
    }

    fun descargarMenu(endpoint: String){

        val call2 = descargarComidas.descargarMenu(endpoint)
        call2.enqueue(object : Callback<Map<String, String>>{
            override fun onResponse(call: Call<Map<String, String>>, response: Response<Map<String, String>>
            ) {
                if (response.isSuccessful) {
                    // Se guardan los valores del menu value
                    menu.value = response.body()
                } else {
                    Log.d("API_TEST_COMEDORES", "FALLO EN OBTENER EL MENU")
                }

            }

            override fun onFailure(call: Call<Map<String, String>>, t: Throwable) {
                Log.d("API_TEST_COMEDORES", "FALLO EN LA CONEXION")
            }

        })
    }
}

