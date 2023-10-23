package mx.itesm.difood.model

import com.google.gson.annotations.SerializedName

/**
 * @author Carlos Alberto Sánchez Calderón
 * Clase ComedorDonaciones
 */
data class ComedorDonaciones(
    @SerializedName("No donaciones")
    val noDonaciones: String,
    @SerializedName("Donaciones")
    val donaciones: String
)
