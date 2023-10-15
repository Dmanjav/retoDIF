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
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import mx.itesm.difoodame.R
import mx.itesm.difoodame.model.TokenResponse
import mx.itesm.difoodame.viewmodel.LoginVM
import mx.itesm.difoodame.viewmodel.MenuComidaVM

class MenuComidaView : AppCompatActivity()
{
    private val viewModel: MenuComidaVM by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_comida_view)

        iniciarEventos()
        iniciarObservables()
    }


    fun iniciarEventos(){

        // Llamadas a R para encontrar el elemento VISUAL
        val btnBuscar: Button = findViewById(R.id.btnBuscar)
        val llMenu: LinearLayout = findViewById(R.id.llMenu)
        val spComedor : Spinner = findViewById(R.id.spComedoresMenu)

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
            val nombre = spComedor.selectedItem.toString()

            // Encontrar el ID del comedor en el mapa de VM
            val id = viewModel.comedor.value?.get(nombre)

            //Log.d("API_TEST_ID", "EL ID DEL COMEDOR SELECCIONADO ES: ${id}")

            if (id != null) {
                val endpoint2 = "app/clientes/" + token.toString() +"/get-menu-comedor?idComedor=" + id
                viewModel.descargarMenu(endpoint2)

            }

        }

    }

    // Esta funcion espera a las variables observables
    fun iniciarObservables()
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

        viewModel.menu.observe(this){mapaMenu ->
            // Encontrar los TextView
            val edPostre: TextView = findViewById(R.id.edPostre)
            val edFuerte: TextView = findViewById(R.id.edPlatoF)
            val edEntrada: TextView = findViewById(R.id.edEntrada)

            // Obtener los datos del menu del VM
            val postre = viewModel.menu.value?.get("postre")
            val plato = viewModel.menu.value?.get("plato")
            val entrada = viewModel.menu.value?.get("entrada")

            // Modificar el TextView con los datos del VM
            edPostre.setText(postre.toString().uppercase())
            edFuerte.setText(plato.toString().uppercase())
            edEntrada.setText(entrada.toString().uppercase())

            Log.d("API_TEST_MENU_DEL_DIA", "EL MENU ES: ${postre} ,${plato}, ${entrada}")

        }

    }
}