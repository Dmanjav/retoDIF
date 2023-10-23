package mx.itesm.difoodame.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * @author Andrés Iván Rodríguez Méndez
 * Esta es la interface para poder recibir los datos de la api para los comedores
 */
interface ListaComedoresAPI
{
    @GET  //endpoint
    fun descargarComedores(@Url endpoint:String): Call <Map<String,Int>>
}