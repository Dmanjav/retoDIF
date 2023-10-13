package mx.itesm.difoodame.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.difoodame.model.RegistrarInterface
import mx.itesm.difoodame.model.TokenResponse
import mx.itesm.difoodame.model.UsuarioRegistro
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RegistrarseVM : ViewModel()
{
    val response2= MutableLiveData<String>()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://54.152.103.250:5000/")
            .addConverterFactory(GsonConverterFactory.create())  // JSON
            .build()
    }

    fun enviardatos(curp:String, nombre:String, apellidop: String, apellidom:String,  año: String, condicion:String, pass:String){

        val apiService = retrofit.create(RegistrarInterface::class.java)
        val usuario = UsuarioRegistro(curp, nombre, apellidop, apellidom, año,condicion, pass)
        val call = apiService.registrar(usuario)

        call.enqueue(object : Callback<TokenResponse> {
            override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
                Log.d("API_TEST_REGISTRO", "HOLA ${response.isSuccessful}")
                if (response.isSuccessful){
                    Log.d("API_TEST_REGISTRO", "REGISTRO EXITOSO ${response.body()}")
                    response2.value =response.body().toString()
                    Log.d("API_TEST_REGISTRO", "ESTE ES EL VALOR DEL RESPONSE${response2.value}")
                }
                else {
                    response2.value = "NEL"
                    Log.e("API_TEST_REGISTRO", "${response2.value}")
                }
            }

            override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                Log.e("API_TEST_REGISTRO", "Valiooooo")

            }

        })
    }
}