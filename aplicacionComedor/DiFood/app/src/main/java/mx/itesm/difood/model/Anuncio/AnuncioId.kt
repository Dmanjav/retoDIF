package mx.itesm.difood.model.Anuncio

import com.google.gson.annotations.SerializedName
/**
 * @author Carlos Alberto Sánchez Calderón
 * Clase AnuncioId
 */
data class AnuncioId(
    @SerializedName ("message")
    val message: String,
    @SerializedName ("details")
    val details: String
)
