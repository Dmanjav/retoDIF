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

class EncuestaView : AppCompatActivity() {

    private val viewModel: MenuComidaVM by viewModels()
    private val viewModels: EncuestaVM by viewModels()

    lateinit var mapGlobal : Map<String, Int>
    var miau: Int? = null
    lateinit var token:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_encuesta_view)


        iniciarObservadores()
        iniciareventos()
    }


    fun iniciareventos()
    {
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
                val mensajeError = "No puedes hacer una encuesta \n" +
                        "Intentalo mas Tarde"
                val duracion = Toast.LENGTH_LONG
                val toast = Toast.makeText(applicationContext, mensajeError, duracion)
                toast.show()
            }


        }


    }
}