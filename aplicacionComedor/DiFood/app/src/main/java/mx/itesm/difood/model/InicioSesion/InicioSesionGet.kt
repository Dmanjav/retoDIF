package mx.itesm.difood.model.InicioSesion

import com.google.gson.annotations.SerializedName
/**
 * @author Carlos Alberto Sánchez Calderón
 * Clase InicioSesion
 */
data class InicioSesionGet (
    @SerializedName("token")
    val token: String)
