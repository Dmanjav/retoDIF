package mx.itesm.difood.model.InicioSesion

import com.google.gson.annotations.SerializedName

data class InicioSesionGet (
    @SerializedName("token")
    val token: String)
