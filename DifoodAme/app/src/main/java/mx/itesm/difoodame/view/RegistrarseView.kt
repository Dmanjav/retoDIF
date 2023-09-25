package mx.itesm.difoodame.view

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton
import mx.itesm.difoodame.R


class RegistrarseView : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse_view)

        val btnCurp: FloatingActionButton = findViewById(R.id.btnCurp)
        val btnRegistrarsee: Button = findViewById(R.id.btnRegist)

        btnRegistrarsee.setOnClickListener{
            val intent: Intent = Intent(this, LoginView::class.java)
            startActivity(intent)
        }

        btnCurp.setOnClickListener{
            val url = Uri.parse("https://www.gob.mx/curp/")
            val navegador = Intent(Intent.ACTION_VIEW,url)
            startActivity(navegador)
        }


    }
}