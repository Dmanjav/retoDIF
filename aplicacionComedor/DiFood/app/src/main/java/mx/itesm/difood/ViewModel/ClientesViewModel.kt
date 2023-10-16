package mx.itesm.difood.ViewModel

import android.os.Handler
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.difood.model.ListaServiciosAPI
import mx.itesm.difood.model.Menu.MenuData
import mx.itesm.difood.model.Menu.MenuID
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientesViewModel : ViewModel() {
    val tokenResponse = MutableLiveData<List<String>>()

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

    fun descargarListaServicios(data: String){
        val call = descargaAPI.GetClientes(data)
        call.enqueue(object : Callback<List<String>> {
            override fun onResponse(
                call: Call<List<String>>,
                response: Response<List<String>>
            ) {

                if (response.isSuccessful){
                    Log.d("ApI Test","Respuesta: ${response.body()}")
                    Handler().postDelayed({
                        tokenResponse.value = response.body()
                    },2000)
                }else{
                    Log.d("ApI Test","2: ${response.body()}")
                    tokenResponse.value = listOf("None")
                }
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                Log.d("ApI2 Test","Fallsa: ")
            }
        })
    }
}