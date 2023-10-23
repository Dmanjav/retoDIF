package mx.itesm.difoodame.model

import com.google.gson.annotations.SerializedName


/**
 * @author Andrés Iván Rodríguez Méndez
 * Esta es la clase que guarda el token por parte del API
 */
data class TokenResponse(@SerializedName("token") var token: String)


