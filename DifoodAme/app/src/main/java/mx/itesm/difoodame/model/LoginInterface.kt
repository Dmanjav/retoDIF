import mx.itesm.difoodame.model.TokenResponse
import mx.itesm.difoodame.model.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * @author Andrés Iván Rodríguez Méndez
 * Esta es la interface para hacer el login con el Api, recibe un token unico para la seguridad de los endpoints
 */
interface LoginInterface {
    @POST("app/clientes/login")
    fun verificarIdentidad(@Body credenciales: Usuario): Call<TokenResponse>
}

