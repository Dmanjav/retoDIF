package mx.itesm.difoodame.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RegistrarInterface {
    @POST("app/clientes/registrar-cliente")
    fun registrar(@Body cuerpo:UsuarioRegistro): Call<TokenResponse>
}