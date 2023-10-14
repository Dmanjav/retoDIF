package mx.itesm.difoodame.model

import android.content.Context
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface MenuInterface
{
    // LLAMADA A LA API DE MENU COMEDOR
    @POST("app/clientes/get-menu-comedor")
    fun recibirmenu(@Body comedornombre: Comedor): Call<MenuResponse>
}