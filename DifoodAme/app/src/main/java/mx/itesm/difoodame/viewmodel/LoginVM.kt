package mx.itesm.difoodame.viewmodel

import LoginInterface
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.difoodame.model.LoginModel
import mx.itesm.difoodame.model.TokenResponse
import mx.itesm.difoodame.model.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginVM : ViewModel()
{
    private val modelo = LoginModel()
    val curp = MutableLiveData<String>()
    var pass = MutableLiveData<String>()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://54.152.103.250:5000/")
            .addConverterFactory(GsonConverterFactory.create())  // JSON
            .build()
    }
    val apiService = retrofit.create(LoginInterface::class.java)
    val usuario = Usuario(curp.toString(), pass.toString())
    val call = apiService.verificarIdentidad(usuario)


    fun enviardatos(){
        call.enqueue(object : Callback<TokenResponse>{
            override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
                if (response.isSuccessful){
                    val tokenResponse = response.body()
                    val token = tokenResponse?.token
                }
                else {
                    val tokenResponse = response.body()
                    val token = tokenResponse?.token
                    println("FALLO en LOGIN")
                    println(token)
                }
            }

            override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }



}