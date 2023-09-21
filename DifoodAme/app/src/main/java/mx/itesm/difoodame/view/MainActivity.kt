package mx.itesm.difoodame.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import mx.itesm.difoodame.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin: Button = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
            val intent: Intent = Intent(this, LoginView::class.java)
            startActivity(intent)
        }
        val btnRegistrarse: Button = findViewById(R.id.btnRegistrarse)
        btnRegistrarse.setOnClickListener{
            val intent: Intent = Intent(this, RegistrarseView::class.java)
            startActivity(intent)
        }
    }
}