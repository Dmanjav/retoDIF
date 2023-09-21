package mx.itesm.difoodame

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton


class RegistrarseView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse_view)

        val btnCurp: FloatingActionButton = findViewById(R.id.btnCurp)

        btnCurp.setOnClickListener{
            val url = Uri.parse("https://www.gob.mx/curp/")
            val navegador = Intent(Intent.ACTION_VIEW,url)
            startActivity(navegador)
        }


    }
}