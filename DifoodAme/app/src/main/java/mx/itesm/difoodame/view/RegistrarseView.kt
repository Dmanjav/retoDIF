package mx.itesm.difoodame.view

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning
import mx.itesm.difoodame.R


class RegistrarseView : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse_view)
        registrarEvento()
    }

    fun registrarEvento()
    {
        val btnCurp: FloatingActionButton = findViewById(R.id.btnCurp)
        val btnRegistrarsee: Button = findViewById(R.id.btnRegist)
        val btnQRead: FloatingActionButton = findViewById(R.id.btnLeerQR)
        val edCurp: EditText = findViewById(R.id.edCurp)
        val edNombre: EditText = findViewById(R.id.edNombre)
        val edPaterno: EditText = findViewById(R.id.edPaterno)
        val edMaterno: EditText = findViewById(R.id.edMaterno)
        val scanner = GmsBarcodeScanning.getClient(this)
        btnQRead.setOnClickListener(){
            scanner.startScan()
                .addOnSuccessListener { barcode ->
                    val rawValue: String? = barcode.rawValue
                    val array = rawValue.toString().split("||")
                    val curp = array[0]
                    val array2 = array[1].split("|")
                    val apPaterno = array2[0]
                    val apMaterno = array2[1]
                    val nombre = array2[2]
                    edCurp.setText(curp)
                    edNombre.setText(nombre)
                    edPaterno.setText(apPaterno)
                    edMaterno.setText(apMaterno)

                }
                .addOnCanceledListener {
                    // Task canceled
                }
                .addOnFailureListener { e ->
                    // Task failed with an exception
                }


        }

        btnCurp.setOnClickListener{
            val url = Uri.parse("https://www.gob.mx/curp/")
            val navegador = Intent(Intent.ACTION_VIEW,url)
            startActivity(navegador)
        }

    }
}