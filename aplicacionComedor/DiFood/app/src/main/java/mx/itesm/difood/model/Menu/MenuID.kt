package mx.itesm.difood.model.Menu

import com.google.gson.annotations.SerializedName

/**
 * @author Carlos Alberto Sánchez Calderón
 * Clase MenuId
 */
data class MenuID(
    @SerializedName("idComida")
    val token: String)
