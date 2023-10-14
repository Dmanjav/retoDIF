package mx.itesm.difoodame.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET

interface ListaComedoresAPI
{
    @GET("app/clientes/get-comedores")  //endpoint
    fun descargarComedores(): Call <Map<String,Int>>
}