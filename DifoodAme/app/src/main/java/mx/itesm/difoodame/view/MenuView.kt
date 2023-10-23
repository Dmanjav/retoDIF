package mx.itesm.difoodame.view

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import mx.itesm.difoodame.R

/**
 * @author Andrés Iván Rodríguez Méndez
 * Esta es la vista del menu
 */


class MenuView : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_view)

        animacion()
        iniciarEventos()
    }

    fun iniciarEventos(){

        // Se dan de alta todos los botones que hay en menu
        val btnQr: Button = findViewById(R.id.btnQR)
        val btnMenu: Button = findViewById(R.id.btnMapas)
        val btnMenus: Button = findViewById(R.id.btnMenu)
        val btnEncuesta: Button = findViewById(R.id.btnEncuesta)

        // Se definen todos los setOnClickListener
        btnQr.setOnClickListener{
            // Se cambia de pantalla a GenerarQR
            val intent: Intent = Intent(this, GenerarQRView::class.java)
           // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }

        btnMenu.setOnClickListener{
            // Se abre el mapa de todos los comedores en Google Maps
            val url = Uri.parse("https://www.google.com/maps/d/u/1/edit?mid=1mPXVsc0gXxL5diInaNvG9tZfGEKKLZg&usp=sharing")
            val navegador = Intent(Intent.ACTION_VIEW,url)
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(navegador)
            finish()
        }

        btnMenus.setOnClickListener{
            // Se cambia de pantalla al Menu
            val intent = Intent(this, MenuComidaView::class.java)
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)

        }

        btnEncuesta.setOnClickListener{
            // Se cambia de pantalla a la encuesta
            val intent = Intent(this, EncuestaView::class.java)
            startActivity(intent)

        }
    }

    fun animacion(){

        // Puras cosas para poder animar una imagen
        val difoodTextView = findViewById<ImageView>(R.id.difood)

        val scaleDownX = ObjectAnimator.ofFloat(difoodTextView, "scaleX", 0.0f)
        val scaleDownY = ObjectAnimator.ofFloat(difoodTextView, "scaleY", 0.0f)
        val scaleUpX = ObjectAnimator.ofFloat(difoodTextView, "scaleX", 1.0f)
        val scaleUpY = ObjectAnimator.ofFloat(difoodTextView, "scaleY", 1.0f)

        scaleDownX.duration = 1000
        scaleDownY.duration = 1000

        scaleUpX.duration = 1000
        scaleUpY.duration = 1000

        // Agregar escala de entrada y salida
        val scaleDown = AnimatorSet()
        scaleDown.play(scaleDownX).with(scaleDownY)
        val scaleUp = AnimatorSet()
        scaleUp.play(scaleUpX).with(scaleUpY)

        // Ejecutar la animación
        scaleDown.start()

        // Escuchar el final de la animación de escala hacia abajo
        scaleDown.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                // Iniciar la animación de escala hacia arriba después de "comer" el texto
                scaleUp.start()
            }
        })
    }
}