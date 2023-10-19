package mx.itesm.difoodame.view

import android.content.Context
import android.content.Intent
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
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import mx.itesm.difoodame.R
import mx.itesm.difoodame.model.TokenResponse
import mx.itesm.difoodame.viewmodel.LoginVM
import mx.itesm.difoodame.viewmodel.MenuComidaVM

class MenuComidaView : AppCompatActivity()
{
    private val viewModel: MenuComidaVM by viewModels()
    lateinit var mapGlobal : Map<String, Int>
    var miau: Int? = null
    lateinit var token:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_comida_view)

        iniciarObservables()
        iniciarEventos()

    }


    fun iniciarEventos(){


        // Tomar de las preferencias los datos que nos interesan
        val sharedPref = getSharedPreferences("mySharedPrefs", Context.MODE_PRIVATE)
        token = sharedPref.getString("Token", "").toString()

        // Crear el endpoint para la llamada de la API
        var endpoint = "app/clientes/"+ token+"/get-comedores"
        Log.d("API_TEST", "EL ENDPOINT ES ESTE: ${endpoint}")


        // Llamada a la API
        viewModel.descargarComedores(endpoint)



    }

    // Esta funcion espera a las variables observables
    fun iniciarObservables() {

        viewModel.comedor.observe(this) { mapa ->

            var mapGlobal = mapa
            val milista = ArrayList(mapa.keys)

            // Identificar el spinner del Comedor
            val spComedoresMenu: Spinner = findViewById(R.id.spComedoresMenu)
            val btnBuscar: Button = findViewById(R.id.btnBuscar)


            // Crear el adaptador para modificar el spinner con datos que recibe de la API
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, milista)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)

            spComedoresMenu.adapter = adapter
            btnBuscar.setOnClickListener {
                val nombre = spComedoresMenu.selectedItem.toString()

                // Encontrar el ID del comedor en el mapa de VM
                miau = viewModel.comedor.value?.get(nombre)

                if (miau != null) {
                    var endpoint2 = "app/clientes/" + token.toString() +"/get-menu-comedor?idComedor=" + miau
                    Log.d("API_TEST", "EL ENDPOINT ES ESTE: ${endpoint2}")
                    viewModel.descargarMenu(endpoint2)

                } else {
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Inténtalo más tarde.")
                        .setMessage("Aún no hay menú registrado para hoy.")
                        .setPositiveButton("OK") { dialog, _ ->
                            // Cerrar el AlertDialog y comenzar la actividad MainActivity
                            dialog.dismiss()
                            val enviar = Intent(this, MenuView::class.java)
                            startActivity(enviar)
                        }
                        .show()
                }

                //Log.d("API_TEST_ID", "EL ID DEL COMEDOR SELECCIONADO ES: ${id}")


            }

        }

        viewModel.menu.observe(this) { mapaMenu ->
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
            val llMenu: LinearLayout = findViewById(R.id.llMenu)
            llMenu.visibility = View.VISIBLE

        }
    }
}