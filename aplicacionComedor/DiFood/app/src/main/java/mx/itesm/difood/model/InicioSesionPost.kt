package mx.itesm.difood.model

import com.google.gson.annotations.SerializedName

data class InicioSesionPost(
    @SerializedName("usuario")
    val usuario: String,
    @SerializedName("contraseña")
    val contraseña: String
)
