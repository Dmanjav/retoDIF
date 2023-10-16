package mx.itesm.difood.model.Anuncio

import com.google.gson.annotations.SerializedName

data class AnuncioId(
    @SerializedName ("message")
    val message: String,
    @SerializedName ("details")
    val details: String
)
