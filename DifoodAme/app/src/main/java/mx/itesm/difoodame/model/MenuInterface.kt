package mx.itesm.difoodame.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface MenuInterface
{
    @POST("app/clientes/get-menu-comedor")
    fun recibirmenu(@Body comedornombre: Comedor): Call<MenuResponse>
}