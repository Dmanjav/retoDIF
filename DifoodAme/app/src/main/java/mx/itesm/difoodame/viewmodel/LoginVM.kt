package mx.itesm.difoodame.viewmodel

import LoginInterface
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.difoodame.model.TokenResponse
import mx.itesm.difoodame.model.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginVM : ViewModel()
{
    val token = MutableLiveData<TokenResponse?>()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://54.152.103.250:5000/")
            .addConverterFactory(GsonConverterFactory.create())  // JSON
            .build()
    }



    fun enviardatos(curp:String, pass:String){

        val apiService = retrofit.create(LoginInterface::class.java)
        val usuario = Usuario(curp, pass)
        val call = apiService.verificarIdentidad(usuario)

        call.enqueue(object : Callback<TokenResponse> {
            override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
                Log.d("API_TEST", "HOLA ${response.isSuccessful}")
                if (response.isSuccessful){
                    Log.d("API_TEST", "se logro banda ${response.body()}")
                    token.value = response.body()
                    Log.d("API_TEST", "se logro banda tokeeen: ${token.value?.token}")
                }
                else {
                    token.value = null
                    Log.e("API_TEST", "${token.value}")
                }
            }

            override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                Log.e("API_TEST", "se valio bandaaaaaaaaa")

            }

        })
    }

}