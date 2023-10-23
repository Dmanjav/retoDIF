package mx.itesm.difood.model.InicioSesion

import com.google.gson.annotations.SerializedName
/**
 * @author Carlos Alberto Sánchez Calderón
 * Clase Incio de sesion para la llamada al API
 */
data class InicioSesionPost(
    @SerializedName("usuario")
    val usuario: String,
    @SerializedName("contraseña")
    val contraseña: String
)
