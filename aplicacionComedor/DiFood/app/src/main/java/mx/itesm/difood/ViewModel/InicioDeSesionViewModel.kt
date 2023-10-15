package mx.itesm.difood.ViewModel

import android.os.Handler
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.difood.model.InicioSesion.InicioSesionGet
import mx.itesm.difood.model.InicioSesion.InicioSesionPost
import mx.itesm.difood.model.ListaServiciosAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InicioDeSesionViewModel : ViewModel() {
    val token = MutableLiveData<InicioSesionGet>()

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

    //funcion que manda el login
    fun descargarListaServicios(data: InicioSesionPost){
        val call = descargaAPI.InicioSesion(data)
        call.enqueue(object : Callback<InicioSesionGet>{
            override fun onResponse(
                call: Call<InicioSesionGet>,
                response: Response<InicioSesionGet>) {

                if (response.isSuccessful){
                    Log.d("ApI Test","Respuesta: ${response.body()}")
                    Handler().postDelayed({
                        token.value = response.body()
                    },2000)
                }else{
                    Log.d("ApI Test","2: ${response.body()}")
                    token.value = InicioSesionGet("Nel")
                }
            }

            override fun onFailure(call: Call<InicioSesionGet>, t: Throwable) {
                Log.d("ApI Test","Falla: ")
            }
        })
    }

}