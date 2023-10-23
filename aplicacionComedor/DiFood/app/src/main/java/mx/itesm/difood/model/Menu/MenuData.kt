package mx.itesm.difood.model.Menu

import com.google.gson.annotations.SerializedName

/**
 * @author Carlos Alberto Sánchez Calderón
 * Clase Menu data
 */
data class MenuData(
    @SerializedName("token")
    val token: String,
    @SerializedName("entrada")
    val entrada: String,
    @SerializedName("plato")
    val plato : String,
    @SerializedName("postre")
    val postre: String
)
