package mx.itesm.difoodame.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import mx.itesm.difoodame.R
import mx.itesm.difoodame.model.Encuesta
import mx.itesm.difoodame.viewmodel.EncuestaVM
import mx.itesm.difoodame.viewmodel.MenuComidaVM

/**
 * @author Andrés Iván Rodríguez Méndez
 * Esta es la vista de la encuesta
 */

class EncuestaView : AppCompatActivity() {

    // Se hacen las llamadas a los viewmodels que se van a utilizar
    private val viewModel: MenuComidaVM by viewModels()
    private val viewModels: EncuestaVM by viewModels()
    lateinit var token:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_encuesta_view)

        // Se inicia la parte logica
        iniciarObservadores()
        iniciareventos()
    }


    fun iniciareventos()
    {
        //Recibe el token con el que se hace el login
        val sharedPref = getSharedPreferences("mySharedPrefs", Context.MODE_PRIVATE)
        token = sharedPref.getString("Token", "").toString()

        // Crear el endpoint para la llamada de la API
        var endpoint = "app/clientes/"+ token+"/get-comedores"
        Log.d("API_TEST", "EL ENDPOINT ES ESTE: ${endpoint}")


        // Llamada a la API
        viewModel.descargarComedores(endpoint)



    }


    fun iniciarObservadores(){

        viewModel.comedor.observe(this) { mapa ->

            var mapGlobal = mapa
            val milista = ArrayList(mapGlobal.keys)

            // Identificar el spinner del Comedor
            val spComedoresMenu: Spinner = findViewById(R.id.spEncuestaComedor)

            // Crear el adaptador para modificar el spinner con datos que recibe de la API
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, milista)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)

            spComedoresMenu.adapter = adapter

            //Se crea el segundo endpoitn con el token para la siguiente llamada a la API
            var endpoint = "app/clientes/"+ token+"/get-pedidos"
            Log.d("API_TEST", "EL ENDPOINT ES ESTE: ${endpoint}")

            viewModels.getPedidos(endpoint)

        }

        viewModels.idPedido.observe(this){idPedido ->

            // Detectar elementos del view
            val spGN = findViewById<SeekBar>(R.id.servicoGeneral)
            val spH = findViewById<SeekBar>(R.id.higiene)
            val spC = findViewById<SeekBar>(R.id.calidad)
            val boton = findViewById<Button>(R.id.btnEnviar)

            Log.d("API_TEST", "VALORER del ID PEDIDO ${idPedido}")

            // Si no existe pedido en el usuario no te deja hacer encuesta
            if(idPedido != null){
                boton.visibility = View.VISIBLE
                boton.setOnClickListener(){

                    // Valores de los elementos
                    val califGN = spGN.progress
                    val califH = spH.progress
                    val califC = spC.progress
                    Log.d("API_TEST", "VALORES: ${califGN}, ${califH}, ${califC}, ${idPedido}")
                    val encuesta = Encuesta(token,idPedido,califGN,califH,califC)
                    viewModels.registrarEncuesta(encuesta)

                    }
            } else {
                //Arroja mensaje de error
                val mensajeError = "No puedes hacer una encuesta \n" +
                        "Intentalo mas Tarde"
                val duracion = Toast.LENGTH_LONG
                val toast = Toast.makeText(applicationContext, mensajeError, duracion)
                toast.show()
            }


        }


    }
}