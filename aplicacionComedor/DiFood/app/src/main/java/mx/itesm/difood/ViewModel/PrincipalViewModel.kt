package mx.itesm.difood.ViewModel

import android.os.Handler
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.difood.model.ClienteModel.ClienteData
import mx.itesm.difood.model.ClienteModel.ClienteID
import mx.itesm.difood.model.ComedorDonaciones
import mx.itesm.difood.model.ListaServiciosAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PrincipalViewModel : ViewModel() {
    val donaciones = MutableLiveData<ComedorDonaciones>()

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
    fun descargarListaServicios(url: String){
        val call = descargaAPI.GetDonaciones(url)
        call.enqueue(object : Callback<ComedorDonaciones> {
            override fun onResponse(
                call: Call<ComedorDonaciones>,
                response: Response<ComedorDonaciones>
            ) {

                if (response.isSuccessful){
                    Log.d("ApI Test","Respuesta: ${response.body()}")
                    Handler().postDelayed({
                        donaciones.value = response.body()
                    },2000)
                }else{
                    Log.d("ApI Test","2: ${response.body()}")
                    donaciones.value = ComedorDonaciones("Nel","Nel")
                }
            }

            override fun onFailure(call: Call<ComedorDonaciones>, t: Throwable) {
                Log.d("ApI2 Test","Fallsa: ")
            }
        })
    }
}