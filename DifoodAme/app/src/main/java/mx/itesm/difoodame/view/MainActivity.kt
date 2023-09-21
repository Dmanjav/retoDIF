package mx.itesm.difoodame.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import mx.itesm.difoodame.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniciarEvento()
        animaciontext()
    }


    fun iniciarEvento(){
        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.rotate)
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
        btnRegistrarse.startAnimation(animation)
        btnLogin.startAnimation(animation)

    }
    fun animaciontext(){
        val imageView = findViewById<ImageView>(R.id.imgLogo)
        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.rotate)
        val txv = findViewById<TextView>(R.id.textBienvenidos)
        imageView.startAnimation(animation)
        txv.startAnimation(animation)
    }
}