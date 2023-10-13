package mx.itesm.difood.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * @author Carlos A. Sánchez Calderón
 * Interface de api
 */
interface ListaServiciosAPI {
    @POST("app/comedor/login")
    fun InicioSesion(@Body cuerpo:InicioSesionPost): Call<InicioSesionGet>
}