package mx.itesm.difood.model.Pedido

import com.google.gson.annotations.SerializedName

data class PedidoId(
    @SerializedName ("idPedido")
    val idPedido: String

)
