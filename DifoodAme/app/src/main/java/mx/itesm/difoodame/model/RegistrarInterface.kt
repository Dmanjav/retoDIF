package mx.itesm.difoodame.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * @author Andrés Iván Rodríguez Méndez
 * Esta es la Inteface para el registro de un cliente usa la clase Usuario registro y recibe un token
 */

interface RegistrarInterface {
    @POST("app/clientes/registrar-cliente")
    fun registrar(@Body cuerpo:UsuarioRegistro): Call<TokenResponse>
}