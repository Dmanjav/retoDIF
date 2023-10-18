package mx.itesm.difood.ViewModel

import android.os.Handler
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.difood.model.ListaServiciosAPI
import mx.itesm.difood.model.Pedido.Pedido
import mx.itesm.difood.model.Pedido.PedidoId
import mx.itesm.difood.model.Token
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RegistrarPedidoViewModel : ViewModel() {
    val tokenResponse = MutableLiveData<PedidoId>()
    val clientes = MutableLiveData<MutableList<String>>()

    //retroFit
    private val retroFit by lazy{
        Retrofit.Builder()
            .baseUrl("https://difood.ddns.net")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //objeto que descarga los datos
    private val descargaAPI by lazy {
        retroFit.create(ListaServiciosAPI::class.java)
    }

    //funcion que manda el pedido
    fun descargarListaServicios(data: Pedido){
        val call = descargaAPI.MandarPedido(data)
        call.enqueue(object : Callback<PedidoId> {
            override fun onResponse(
                call: Call<PedidoId>,
                response: Response<PedidoId>
            ) {

                if (response.isSuccessful){
                    Log.d("ApI Test","Respuesta: ${response.body()}")
                    Handler().postDelayed({
                       tokenResponse.value = response.body()
                    },2000)
                }else{
                    Log.d("ApI Test","2: ${response.body()}")
                    tokenResponse.value = PedidoId("Nel")
                }
            }

            override fun onFailure(call: Call<PedidoId>, t: Throwable) {
                Log.d("ApI2 Test","Fallsa: ")
            }
        })
    }

    fun descargarListaServicios2(url: String){
        val call = descargaAPI.GetDependientes(url)
        call.enqueue(object : Callback<Map<String,List<List<String>>>> {
            override fun onResponse(
                call: Call<Map<String,List<List<String>>>>,
                response: Response<Map<String,List<List<String>>>>
            ) {

                if (response.isSuccessful){
                    Log.d("ApI Test","Respuesta: ${response.body()}")
                    Handler().postDelayed({
                        val listaNom = mutableListOf<String>()
                        response.body()?.forEach{t,u ->

                            Log.d("API_Cl","L")

                            u.forEach{x ->
                                Log.d("API_Cl",x.toString())
                                val aux: String = x[0]
                                listaNom.add(aux)
                            }
                        }

                        clientes.value = listaNom
                    },2000)
                }else{
                    Log.d("ApI Test","2: ${response.body()}")
                    tokenResponse.value = PedidoId("Nel")
                }
            }

            override fun onFailure(call: Call<Map<String,List<List<String>>>>, t: Throwable) {
                Log.d("ApI2 Test","Fallsa: ")
            }
        })
    }
}