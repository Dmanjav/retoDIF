package mx.itesm.difoodame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_view)

        val btncurp : Button = findViewById(R.id.btnIngresar)

        btncurp.setOnClickListener{
            val intent: Intent = Intent(this, RegistrarseView::class.java)
            startActivity(intent)
        }

    }
}