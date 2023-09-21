package mx.itesm.difoodame.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton
import mx.itesm.difoodame.R

class LoginView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_view)

        val btnCurp2 : FloatingActionButton = findViewById(R.id.btnCurp2)

        btnCurp2.setOnClickListener{
            val url = Uri.parse("https://www.gob.mx/curp/")
            val navegador = Intent(Intent.ACTION_VIEW,url)
            startActivity(navegador)
        }

    }
}