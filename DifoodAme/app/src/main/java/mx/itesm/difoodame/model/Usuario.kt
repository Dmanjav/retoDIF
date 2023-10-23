package mx.itesm.difoodame.model


import com.google.gson.annotations.SerializedName

/**
 * @author Andrés Iván Rodríguez Méndez
 * Esta es la clase Usuario, se usa para el login y almacena los datos del login para enviarlos al API
 */

data class Usuario(@SerializedName("usuario") val curp: String, @SerializedName("contraseña") val password: String)
