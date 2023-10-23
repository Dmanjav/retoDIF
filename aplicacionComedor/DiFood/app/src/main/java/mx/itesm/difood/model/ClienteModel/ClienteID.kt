package mx.itesm.difood.model.ClienteModel

import android.telecom.Call.Details
import com.google.gson.annotations.SerializedName

/**
 * @author Carlos Alberto Sánchez Calderón
 * Clase ClienteId
 */

data class ClienteID(
    @SerializedName ("message")
    val message: String,
    @SerializedName ("details")
    val details: String
)
