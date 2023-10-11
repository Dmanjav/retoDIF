import mx.itesm.difoodame.model.TokenResponse
import mx.itesm.difoodame.model.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginInterface {
    @POST("app/clientes/login")
    fun verificarIdentidad(@Body credenciales: Usuario): Call<TokenResponse>
}

