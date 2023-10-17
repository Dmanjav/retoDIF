package mx.itesm.difood.ViewModel

import android.os.Handler
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.difood.model.ClienteModel.ClienteData
import mx.itesm.difood.model.ClienteModel.ClienteID
import mx.itesm.difood.model.ListaServiciosAPI
import mx.itesm.difood.model.Pedido.Pedido
import mx.itesm.difood.model.Pedido.PedidoId
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RegistrarClienteViewModel : ViewModel() {
    val tokenResponse = MutableLiveData<ClienteID>()

    //retroFit
    private val retroFit by lazy{
        Retrofit.Builder()
            .baseUrl("https://difood.ddns.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //objeto que descarga los datos
    private val descargaAPI by lazy {
        retroFit.create(ListaServiciosAPI::class.java)
    }

    //funcion que manda el pedido
    fun descargarListaServicios(data: ClienteData){
        val call = descargaAPI.MandarCliente(data)
        call.enqueue(object : Callback<ClienteID> {
            override fun onResponse(
                call: Call<ClienteID>,
                response: Response<ClienteID>
            ) {

                if (response.isSuccessful){
                    Log.d("ApI Test","Respuesta: ${response.body()}")
                    Handler().postDelayed({
                        tokenResponse.value = response.body()
                    },2000)
                }else{
                    Log.d("ApI Test","2: ${response.body()}")
                    tokenResponse.value = ClienteID("Nel","Nel")
                }
            }

            override fun onFailure(call: Call<ClienteID>, t: Throwable) {
                Log.d("ApI2 Test","Fallsa: ")
            }
        })
    }
}