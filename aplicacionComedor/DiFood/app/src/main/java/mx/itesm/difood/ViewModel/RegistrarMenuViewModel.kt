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

class RegistrarMenuViewModel : ViewModel() {
    val tokenResponse = MutableLiveData<MenuID>()

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

    fun descargarListaServicios(data: MenuData){
        val call = descargaAPI.MandarMenu(data)
        call.enqueue(object : Callback<MenuID> {
            override fun onResponse(
                call: Call<MenuID>,
                response: Response<MenuID>
            ) {

                if (response.isSuccessful){
                    Log.d("ApI Test","Respuesta: ${response.body()}")
                    Handler().postDelayed({
                        tokenResponse.value = response.body()
                    },2000)
                }else{
                    Log.d("ApI Test","2: ${response.body()}")
                    tokenResponse.value = MenuID("Nel")
                }
            }

            override fun onFailure(call: Call<MenuID>, t: Throwable) {
                Log.d("ApI2 Test","Fallsa: ")
            }
        })
    }
}