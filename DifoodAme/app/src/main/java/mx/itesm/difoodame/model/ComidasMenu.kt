package mx.itesm.difoodame.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * @author Andrés Iván Rodríguez Méndez
 * Esta es la clase Comidas Menu, recibe un mapa de strings donde recibe todas las comidas del dia en el comedor solicitado
 */

interface ComidasMenu
{
    @GET
    fun descargarMenu(@Url endpoint: String): Call <Map<String,String>>
}