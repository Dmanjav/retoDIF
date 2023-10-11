package mx.itesm.difoodame.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.floatingactionbutton.FloatingActionButton
import mx.itesm.difoodame.R
import mx.itesm.difoodame.databinding.ActivityMainBinding


class LoginView : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_view)
        binding = ActivityMainBinding.inflate(layoutInflater)
        registrarEventos()
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
            val curp = edtCurp.text.toString()
            val pass =  edtPass.text.toString()

            val intent: Intent = Intent(this, MenuView::class.java)
            startActivity(intent)
        }

    }

}