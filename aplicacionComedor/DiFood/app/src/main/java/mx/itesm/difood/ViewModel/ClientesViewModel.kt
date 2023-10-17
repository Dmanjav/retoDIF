package mx.itesm.difood.ViewModel

import android.os.Handler
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.difood.model.Clientes.ClienteLista
import mx.itesm.difood.model.ComedorDonaciones
import mx.itesm.difood.model.ListaServiciosAPI
import mx.itesm.difood.model.Menu.MenuData
import mx.itesm.difood.model.Menu.MenuID
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientesViewModel : ViewModel() {
    var clientes = MutableLiveData<MutableList<String>>()

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

    fun descargarListaServicios(url: String){
        val call = descargaAPI.GetClientes(url)
        call.enqueue(object : Callback<Map<String,List<List<String>>>> {
            override fun onResponse(
                call: Call<Map<String,List<List<String>>>>,
                response: Response<Map<String,List<List<String>>>>
            ) {

                if (response.isSuccessful){
                    Log.d("ApI Test","Respuesta3:")
                    Handler().postDelayed({
                        //tokenResponse.value = response.body()

                        val listaNom = mutableListOf<String>()
                        response.body()?.forEach{t,u ->

                            //Log.d("API_Cl",u.toString() + "/"+ t.toString())

                            u.forEach{x ->
                                //Log.d("API_Cl",x.toString())
                                val aux: String = x[0]+" "+x[1]+" "+x[2]
                                listaNom.add(aux)
                            }
                        }

                        clientes.value = listaNom
                        //Log.d("API_Cl",listaNom.toString())

                    },2000)
                }else{
                    Log.d("ApI Test","2: ")
                    //tokenResponse.value = listOf("None")
                }
            }

            override fun onFailure(call: Call<Map<String,List<List<String>>>>, t: Throwable) {
                Log.d("ApI2 Test","Fallsa: ")
            }
        })
    }
}