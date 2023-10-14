package mx.itesm.difoodame.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Spinner
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import mx.itesm.difoodame.R
import mx.itesm.difoodame.model.TokenResponse
import mx.itesm.difoodame.viewmodel.LoginVM
import mx.itesm.difoodame.viewmodel.MenuComidaVM

class MenuComidaView : AppCompatActivity()
{

    private val viewModel: MenuComidaVM by viewModels()
    private val viewModel2: LoginVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_comida_view)

        iniciarEventos()
        iniciarspinner()
    }

    fun iniciarEventos(){

        // Llamadas a R para encontrar el elemento VISUAL
        val btnBuscar: Button = findViewById(R.id.btnBuscar)
        val llMenu: LinearLayout = findViewById(R.id.llMenu)

        // Tomar de las preferencias los datos que nos interesan
        val sharedPref = getSharedPreferences("mySharedPrefs", Context.MODE_PRIVATE)
        val token = sharedPref.getString("Token", "")

        // Crear el endpoint para la llamada de la API
        val endpoint = "app/clientes/" + token.toString() +"/get-comedores"

        // Llamada a la API
        viewModel.descargarComedores(endpoint)

        // Listeners
        btnBuscar.setOnClickListener{
            llMenu.visibility= View.VISIBLE
        }

    }

    // Esta funcion espera a las variables observables
    fun iniciarspinner()
    {

        viewModel.comedor.observe(this){mapa ->

            val milista = ArrayList(mapa.keys)

            // Identificar el spinner del Comedor
            val spComedoresMenu: Spinner = findViewById(R.id.spComedoresMenu)

            // Crear el adaptador para modificar el spinner con datos que recibe de la API
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,milista)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
            spComedoresMenu.adapter = adapter
        }
    }
}