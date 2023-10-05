package mx.itesm.difoodame.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import mx.itesm.difoodame.R

class MenuComidaView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_comida_view)

        val btnBuscar: Button = findViewById(R.id.btnBuscar)
        val llMenu: LinearLayout = findViewById(R.id.llMenu)

        btnBuscar.setOnClickListener{
            llMenu.visibility= View.VISIBLE
        }
    }
}