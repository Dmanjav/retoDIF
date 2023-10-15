package mx.itesm.difood.model

import mx.itesm.difood.model.InicioSesion.InicioSesionGet
import mx.itesm.difood.model.InicioSesion.InicioSesionPost
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * @author Carlos A. Sánchez Calderón
 * Interface de api
 */
interface ListaServiciosAPI {
    @POST("app/comedor/login")
    fun InicioSesion(@Body cuerpo: InicioSesionPost): Call<InicioSesionGet>

    @POST("app/comedor/generar-pedido")
    fun MandarPedido(@Body cuerpo: Pedido): Call<Token>
}