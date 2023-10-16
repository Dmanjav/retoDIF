package mx.itesm.difood.model.Anuncio

import com.google.gson.annotations.SerializedName

data class AnuncioData(
    @SerializedName ("token")
    val token: String,
    @SerializedName ("contenido")
    val contenido: String,
    @SerializedName ("cierre")
    val cierre: String
)
