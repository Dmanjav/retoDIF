package mx.itesm.difoodame.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Url

interface ListaComedoresAPI
{
    @GET  //endpoint
    fun descargarComedores(@Url endpoint:String): Call <Map<String,Int>>
}