package mx.itesm.difood.model

import com.google.gson.annotations.SerializedName

data class InicioSesionGet (
    @SerializedName("token")
    val token: String)
