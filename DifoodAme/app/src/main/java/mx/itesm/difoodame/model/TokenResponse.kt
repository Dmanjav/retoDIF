package mx.itesm.difoodame.model

import com.google.gson.annotations.SerializedName

//data class TokenResponse(val token: String)

data class TokenResponse(
    @SerializedName("token") var token: String
)


