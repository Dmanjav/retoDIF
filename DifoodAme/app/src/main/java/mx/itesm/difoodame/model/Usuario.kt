package mx.itesm.difoodame.model


import com.google.gson.annotations.SerializedName

data class Usuario(@SerializedName("usuario") val curp: String, @SerializedName("contraseña") val password: String)
