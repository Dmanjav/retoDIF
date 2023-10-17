package mx.itesm.difood.model

import com.google.gson.annotations.SerializedName

data class ComedorDonaciones(
    @SerializedName("No donaciones")
    val noDonaciones: String,
    @SerializedName("Donaciones")
    val donaciones: String
)
