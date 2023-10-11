package mx.itesm.difoodame.view

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import mx.itesm.difoodame.R

class MenuView : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_view)

        val btnQr: Button = findViewById(R.id.btnQR)
        val btnMenu: Button = findViewById(R.id.btnMapas)
        val btnMenus: Button = findViewById(R.id.btnMenu)
        val btnEncuesta: Button = findViewById(R.id.btnEncuesta)

        btnQr.setOnClickListener{
            val intent: Intent = Intent(this, GenerarQRView::class.java)
            startActivity(intent)
        }

        btnMenu.setOnClickListener{
            val url = Uri.parse("https://www.google.com/maps/d/u/1/edit?mid=1mPXVsc0gXxL5diInaNvG9tZfGEKKLZg&usp=sharing")
            val navegador = Intent(Intent.ACTION_VIEW,url)
            startActivity(navegador)
        }

        btnMenus.setOnClickListener{
            val intent = Intent(this, MenuComidaView::class.java)
            startActivity(intent)
        }

        btnEncuesta.setOnClickListener{
            val intent = Intent(this, EncuestaView::class.java)
            startActivity(intent)
        }
    }
}