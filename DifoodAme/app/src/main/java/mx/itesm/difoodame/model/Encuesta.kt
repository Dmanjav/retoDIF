package mx.itesm.difoodame.model

/**
 * @author Andrés Iván Rodríguez Méndez
 * Clase encuesta, para crearla debe tener los parametros para hacer el envio de la encuesta
 */

data class Encuesta(val token: String, val idPedido: Int, val servicio: Int, val higiene: Int, val calidad: Int)
