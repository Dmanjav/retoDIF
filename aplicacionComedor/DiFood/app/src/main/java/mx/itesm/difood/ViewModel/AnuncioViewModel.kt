package mx.itesm.difood.ViewModel

import android.os.Handler
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.difood.model.Anuncio.AnuncioData
import mx.itesm.difood.model.Anuncio.AnuncioId
import mx.itesm.difood.model.ClienteModel.ClienteData
import mx.itesm.difood.model.ClienteModel.ClienteID
import mx.itesm.difood.model.ListaServiciosAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AnuncioViewModel : ViewModel() {
    val tokenResponse = MutableLiveData<AnuncioId>()

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
    fun descargarListaServicios(data: AnuncioData){
        val call = descargaAPI.MandarAnuncio(data)
        call.enqueue(object : Callback<AnuncioId> {
            override fun onResponse(
                call: Call<AnuncioId>,
                response: Response<AnuncioId>
            ) {

                if (response.isSuccessful){
                    Log.d("ApI Test","Respuesta: ${response.body()}")
                    Handler().postDelayed({
                        tokenResponse.value = response.body()
                    },2000)
                }else{
                    Log.d("ApI Test","2: ${response.body()}")
                    tokenResponse.value = AnuncioId("Nel","Nel")
                }
            }

            override fun onFailure(call: Call<AnuncioId>, t: Throwable) {
                Log.d("ApI2 Test","Fallsa: ")
            }
        })
    }
}