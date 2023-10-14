package mx.itesm.difoodame.viewmodel

import android.telecom.CallEndpoint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.difoodame.model.Comedor
import mx.itesm.difoodame.model.ListaComedoresAPI
import mx.itesm.difoodame.model.TokenResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MenuComidaVM : ViewModel()
{

    val comedor = MutableLiveData<Map<String, Int>>()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://54.152.103.250:5000/")
            .addConverterFactory(GsonConverterFactory.create())  // JSON
            .build()
    }

    private val descargarAPI by lazy {
        retrofit.create(ListaComedoresAPI::class.java)
    }

    fun descargarComedores(endpoint: String)
    {
        val call = descargarAPI.descargarComedores(endpoint)

        call.enqueue(object : Callback<Map<String,Int>> {

            override fun onResponse(
                call: Call<Map<String, Int>>,
                response: Response<Map<String, Int>>
            )
            {

                if (response.isSuccessful){
                    comedor.value = response.body()
//                    comedor.value?.forEach({
//                        (nombre, id) ->
//                        Log.d("API_TEST_COMEDORES", "COMEDORES: ${nombre} ${id}")
//                    })
                } else {
                    Log.d("API_TEST_COMEDORES", "FALLO EN OBTENER COMEDORES")
                }
            }

            override fun onFailure(call: Call<Map<String, Int>>, t: Throwable) {
                Log.d("API_TEST_COMEDORES", "FALLO EN CONEXION")
            }

        })
    }
}