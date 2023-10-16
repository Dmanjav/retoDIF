package mx.itesm.difood.model

import mx.itesm.difood.model.Anuncio.AnuncioData
import mx.itesm.difood.model.Anuncio.AnuncioId
import mx.itesm.difood.model.ClienteModel.ClienteData
import mx.itesm.difood.model.ClienteModel.ClienteID
import mx.itesm.difood.model.InicioSesion.InicioSesionGet
import mx.itesm.difood.model.InicioSesion.InicioSesionPost
import mx.itesm.difood.model.Menu.MenuData
import mx.itesm.difood.model.Menu.MenuID
import mx.itesm.difood.model.Pedido.Pedido
import mx.itesm.difood.model.Pedido.PedidoId
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * @author Carlos A. Sánchez Calderón
 * Interface de api
 */
interface ListaServiciosAPI {
    @POST("app/comedor/login")
    fun InicioSesion(@Body cuerpo: InicioSesionPost): Call<InicioSesionGet>

    @POST("app/comedor/generar-pedido")
    fun MandarPedido(@Body cuerpo: Pedido): Call<PedidoId>

    @POST("app/comedor/publicar-menu")
    fun MandarMenu(@Body cuerpo: MenuData): Call<MenuID>

    @GET("app/comedor/<token>/get-clientes")
    fun GetClientes(@Body token: String): Call<List<String>>

    @POST("/app/comedor/registrar-cliente")
    fun MandarCliente(@Body cuerpo: ClienteData): Call<ClienteID>

    @POST("/app/comedor/publicar-anuncio")
    fun MandarAnuncio(@Body cuerpo: AnuncioData): Call<AnuncioId>

}