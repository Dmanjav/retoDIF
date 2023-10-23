package mx.itesm.difood.model.Clientes

import com.google.gson.annotations.SerializedName

/**
 * @author Carlos Alberto Sánchez Calderón
 * Clase ClienteLista
 */

data class ClienteLista(
    val nombre: String,
    val apellidoP: String,
    val apellidoM: String
)