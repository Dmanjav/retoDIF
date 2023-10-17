package mx.itesm.difoodame.viewmodel

import LoginInterface
import android.media.session.MediaSession.Token
import android.util.Log
import android.widget.Toast
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
            //.baseUrl("http://difood.ddns.net:5000/")
            .baseUrl("https://difood.ddns.net/")
            .addConverterFactory(GsonConverterFactory.create())  // JSON
            .build()
    }


    fun enviardatos(curp:String, pass:String){

        val apiService = retrofit.create(LoginInterface::class.java)
        // Se crea el Objeto Usuario con el Curp y password para hacer login
        val usuario = Usuario(curp, pass)
        val call = apiService.verificarIdentidad(usuario)

        call.enqueue(object : Callback<TokenResponse> {
            override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {

                if (response.isSuccessful){
                    // Si la respuesta del servidor es "Successful" se guarda la variable token con el body del response
                    Log.d("API_TEST", "se logro banda ${response.body()}")
                    token.value = response.body()
                    Log.d("API_TEST", "se logro banda tokeeen: ${token.value?.token}")
                }
                else {
                    // Si la respuesta del servidor no es "Successful" se guarda la variable token con null
                    token.value = null
                    Log.e("API_TEST", "${token.value}")
                }
            }

            // Fallo en la conexion del con el servidor
            override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                Log.e("API_TEST", "NO SE PUDO CONECTAR CON EL SERVER")
                token.value = TokenResponse("ERROR")

            }

        })
    }

}