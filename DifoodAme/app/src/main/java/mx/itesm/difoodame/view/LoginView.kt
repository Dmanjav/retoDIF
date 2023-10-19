package mx.itesm.difoodame.view

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import com.google.android.material.floatingactionbutton.FloatingActionButton
import mx.itesm.difoodame.R
import mx.itesm.difoodame.databinding.ActivityMainBinding
import mx.itesm.difoodame.model.TokenResponse
import mx.itesm.difoodame.viewmodel.LoginVM


class LoginView : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private val viewModel: LoginVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_view)
        registrarEventos()

    }

    private fun registrarObservables() {
        viewModel.token.observe(this){variable ->
            val btnLogin: Button = findViewById(R.id.btnIngresar)
            Log.d("API_TEST", "Observables ${variable?.token}")
            if (variable != null){
                val sharedPref = getSharedPreferences("mySharedPrefs", Context.MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.putString("Token", variable.token)
                editor.apply()
                val intent = Intent(this, MenuView::class.java)
                startActivity(intent)
                finish()
            } else if (variable == null) {
                val mensajeError = "CURP o Contraseña Incorrectas, Verificalas :) "
                val duracion = Toast.LENGTH_LONG
                btnLogin.visibility = View.VISIBLE

                val toast = Toast.makeText(applicationContext, mensajeError, duracion)
                toast.show()
            } else {
                val mensajeError = " Verifica tu conexión"
                val duracion = Toast.LENGTH_LONG

                val toast = Toast.makeText(applicationContext, mensajeError, duracion)
                toast.show()
            }
        }
    }


    fun registrarEventos(){

        val btnCurp2 : FloatingActionButton = findViewById(R.id.btnCurp2)
        btnCurp2.setOnClickListener{
            val url = Uri.parse("https://www.gob.mx/curp/")
            val navegador = Intent(Intent.ACTION_VIEW,url)
            startActivity(navegador)
        }

        val edtCurp: EditText = findViewById(R.id.edtCurp)
        val btnLogin: Button = findViewById(R.id.btnIngresar)
        val edtPass: EditText = findViewById(R.id.edtPass)

        btnLogin.setOnClickListener {
            val curp = edtCurp.text.toString().uppercase()
            val pass =  edtPass.text.toString()
            btnLogin.visibility = View.INVISIBLE

            viewModel.enviardatos(curp,pass)
            registrarObservables()

            val sharedPref = getSharedPreferences("mySharedPrefs", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString("CurpUsuario", curp)
            editor.apply()

            }

        }


    }
