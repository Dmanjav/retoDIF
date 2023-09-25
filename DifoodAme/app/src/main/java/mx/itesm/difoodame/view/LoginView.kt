package mx.itesm.difoodame.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import com.google.android.material.floatingactionbutton.FloatingActionButton
import mx.itesm.difoodame.R
import javax.microedition.khronos.egl.EGLDisplay

class LoginView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_view)

        registrarEventos()
    }

    fun registrarEventos(){
        val btnCurp2 : FloatingActionButton = findViewById(R.id.btnCurp2)

        btnCurp2.setOnClickListener{
            val url = Uri.parse("https://www.gob.mx/curp/")
            val navegador = Intent(Intent.ACTION_VIEW,url)
            startActivity(navegador)
        }
        verificarcampos()

        val btnLogin: Button = findViewById(R.id.btnIngresar)
        btnLogin.setOnClickListener {
            val intent: Intent = Intent(this, MenuView::class.java)
            startActivity(intent)
        }

    }

    fun verificarcampos(){
        val textCurp: EditText = findViewById(R.id.edtCurp)
        val textPass: EditText = findViewById(R.id.edPass)

        textCurp.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val textoo = textCurp.text.toString()
                val passs = textPass.text.toString()
                if (textoo.isNotEmpty() && passs.isNotEmpty()){
                    val btnLogin: Button = findViewById(R.id.btnIngresar)
                    btnLogin.isEnabled

                }
            }

            override fun afterTextChanged(p0: Editable?) {
                TODO("Not yet implemented")
            }

        })

    }
}