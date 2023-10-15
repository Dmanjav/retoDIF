package mx.itesm.difoodame.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Url

interface ComidasMenu
{
    @GET
    fun descargarMenu(@Url endpoint: String): Call <Map<String,String>>
}