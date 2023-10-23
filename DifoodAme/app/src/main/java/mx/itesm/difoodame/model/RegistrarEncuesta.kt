package mx.itesm.difoodame.model


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url
/**
 * @author Andrés Iván Rodríguez Méndez
 * Esta es la interface para hacer el registro de la encuesta, primero hace una solicitud a la API y si existe respuesta
 * envia la encuesta
 */

interface RegistrarEncuesta
{
    @GET
    fun obtenerPedido(@Url endpoint: String): Call<Map<String,Map<String,String>>>

    @POST("app/clientes/publicar-evaluacion")
    fun registrarEncuesta(@Body encuesta: Encuesta): Call<String>

}