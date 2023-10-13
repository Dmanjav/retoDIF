package mx.itesm.difoodame.model

import com.google.gson.annotations.SerializedName

data class UsuarioRegistro(@SerializedName("curp") val curp: String,
                           @SerializedName("nombre") val nombre: String,
                           @SerializedName("apellidop") val apellidop:String,
                           @SerializedName("apellidom") val apellidom:String,
                           @SerializedName("añoNacimiento") val año: String,
                           @SerializedName("condicion") val condicion: String,
                           @SerializedName("contraseña") val password: String)
