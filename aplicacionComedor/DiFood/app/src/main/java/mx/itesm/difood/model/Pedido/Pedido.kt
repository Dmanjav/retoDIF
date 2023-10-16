package mx.itesm.difood.model.Pedido

import com.google.gson.annotations.SerializedName

data class Pedido (
    @SerializedName("token")
    val token: String,
    @SerializedName("donacion")
    val donacion: String,
    @SerializedName("responsable")
    val responsable: String,
    @SerializedName("dependiente")
    val dependiente: String,
    @SerializedName("idComida")
    val idComida: String
    )
