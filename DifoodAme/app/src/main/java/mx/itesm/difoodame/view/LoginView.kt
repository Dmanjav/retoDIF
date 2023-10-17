package mx.itesm.difoodame.view

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
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
        if (isInternetAvailable(this    )){
            registrarEventos()
            registrarObservables()
        } else{
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Error en conexión")
                .setMessage("Verifica tu conexión a internet")
                .setPositiveButton("OK") { dialog, _ ->
                    // Cerrar el AlertDialog y comenzar la actividad MainActivity
                    dialog.dismiss()
                    val enviar = Intent(this, MainActivity::class.java)
                    startActivity(enviar)
                }
                .show()
        }



    }

    private fun registrarObservables() {
        viewModel.token.observe(this){variable ->
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

            viewModel.enviardatos(curp,pass)
            registrarObservables()

            val sharedPref = getSharedPreferences("mySharedPrefs", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString("CurpUsuario", curp)
            editor.apply()

            }

        }

    fun isInternetAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        // Comprueba la información de la red activa
        val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo

        return networkInfo?.isConnected == true
    }


    }
