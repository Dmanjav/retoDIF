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

        // Se crea un objeto Usuario que se envia al API
        val usuario = UsuarioRegistro(curp, nombre, apellidop, apellidom, año,condicion, pass)
        val call = apiService.registrar(usuario)

        call.enqueue(object : Callback<TokenResponse> {
            override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {

                if (response.isSuccessful){

                    // El post de registro es exitoso
                    Log.d("API_TEST_REGISTRO", "REGISTRO EXITOSO ${response.body()}")
                    response2.value =response.body().toString()

                }
                else {
                    // El post de registro no es exitoso
                    response2.value = "NEL"
                    Log.e("API_TEST_REGISTRO", "${response2.value}")
                }
            }

            override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                Log.e("API_TEST_REGISTRO", "FALLO EN LA CONEXION CON EL SERVER")

            }

        })
    }
}