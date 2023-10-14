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

        val btnBuscar: Button = findViewById(R.id.btnBuscar)
        val llMenu: LinearLayout = findViewById(R.id.llMenu)
        iniciarspinner()
        val sharedPref = getSharedPreferences("mySharedPrefs", Context.MODE_PRIVATE)
        val token = sharedPref.getString("Token", "")
        Log.d("API_TEST_C_MENU", "${token.toString()}")
        viewModel.descargarComedores()
        btnBuscar.setOnClickListener{
            llMenu.visibility= View.VISIBLE
        }
    }

    fun iniciarspinner()
    {
        viewModel.comedor.observe(this){mapa ->
            val milista = ArrayList<String>()
            milista.add("Hola")
            milista.add("Adios")
            milista.add("Hola")
            //val arrComedores = lista.toTypedArray()
            val spComedoresMenu: Spinner = findViewById(R.id.spComedoresMenu)
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,milista)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
            spComedoresMenu.adapter = adapter

        }
    }
}