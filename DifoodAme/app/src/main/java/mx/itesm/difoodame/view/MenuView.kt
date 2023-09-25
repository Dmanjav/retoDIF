package mx.itesm.difoodame.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import mx.itesm.difoodame.R

class MenuView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_view)

        val btnQr: Button = findViewById(R.id.btnQR)

        btnQr.setOnClickListener{
            val intent: Intent = Intent(this, GenerarQRView::class.java)
            startActivity(intent)
        }
    }
}