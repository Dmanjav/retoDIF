package mx.itesm.difood.ViewModel

import android.os.Handler
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.difood.model.ListaServiciosAPI
import mx.itesm.difood.model.Pedido
import mx.itesm.difood.model.Token
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RegistrarPedidoViewModel : ViewModel() {
    val tokenResponse = MutableLiveData<Token>()

    //retroFit
    private val retroFit by lazy{
        Retrofit.Builder()
            .baseUrl("http://54.152.103.250:5000/")
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
        call.enqueue(object : Callback<Token> {
            override fun onResponse(
                call: Call<Token>,
                response: Response<Token>
            ) {

                if (response.isSuccessful){
                    Log.d("ApI Test","Respuesta: ${response.body()}")
                    Handler().postDelayed({
                       // tokenResponse.value = response.body()
                    },2000)
                }else{
                    Log.d("ApI Test","2: ${response.body()}")
                    //tokenResponse.value = Token("Nel")
                }
            }

            override fun onFailure(call: Call<Token>, t: Throwable) {
                Log.d("ApI2 Test","Fallsa: ")
            }
        })
    }
}