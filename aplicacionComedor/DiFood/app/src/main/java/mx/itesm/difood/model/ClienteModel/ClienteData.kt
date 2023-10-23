package mx.itesm.difood.model.ClienteModel

import com.google.gson.annotations.SerializedName
/**
 * @author Carlos Alberto Sánchez Calderón
 * Clase Clientes, se usa para el registro
 */
data class ClienteData(
    @SerializedName("token")
    val token: String,
    @SerializedName("curp")
    val curp: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("apellidop")
    val apellidoP: String,
    @SerializedName("apellidom")
    val apellidoM: String,
    @SerializedName("añoNacimiento")
    val añoNacimiento: String,
    @SerializedName("condicion")
    val condicion: String,
    @SerializedName("contraseña")
    val contraseña: String,
    @SerializedName("curp-responsable")
    val curpResp: String
)
