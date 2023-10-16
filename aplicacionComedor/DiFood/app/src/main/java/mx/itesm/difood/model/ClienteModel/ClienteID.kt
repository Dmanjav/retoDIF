package mx.itesm.difood.model.ClienteModel

import android.telecom.Call.Details
import com.google.gson.annotations.SerializedName

data class ClienteID(
    @SerializedName ("message")
    val message: String,
    @SerializedName ("details")
    val details: String
)
