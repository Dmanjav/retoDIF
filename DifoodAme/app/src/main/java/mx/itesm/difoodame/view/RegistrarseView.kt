package mx.itesm.difoodame.view

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.viewModels
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning
import mx.itesm.difoodame.R
import mx.itesm.difoodame.viewmodel.RegistrarseVM


class RegistrarseView : AppCompatActivity() {

    private val viewModel: RegistrarseVM by viewModels()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse_view)
        iniciarEvento()
        registrarObservables()
    }

    fun iniciarEvento()
    {

        // Nombramos y llamamos a todos los elementos de la pantalla de Registro para poder manipularlos
        val btnCurp: FloatingActionButton = findViewById(R.id.btnCurp)
        val btnRegistrarsee: Button = findViewById(R.id.btnRegist)
        val btnQRead: FloatingActionButton = findViewById(R.id.btnLeerQR)
        val edCurp: EditText = findViewById(R.id.edCurp)
        val edNombre: EditText = findViewById(R.id.edNombre)
        val edContrasena: EditText = findViewById(R.id.edContrasena)
        val edPaterno: EditText = findViewById(R.id.edPaterno)
        val edMaterno: EditText = findViewById(R.id.edMaterno)
        val edAño: EditText = findViewById(R.id.edAño)
        val condicion: Spinner = findViewById(R.id.spCondiciones)

        // Se crea una variable para poder Leer QR
        val scanner = GmsBarcodeScanning.getClient(this)

        // Si el boton para leer el QR es presionado se hace el proceso de autocompletado de datos
        btnQRead.setOnClickListener(){
            scanner.startScan()
                .addOnSuccessListener { barcode ->
                    val rawValue: String? = barcode.rawValue

                    // Se divide la informacion del String que se recibio
                    val array = rawValue.toString().split("||")
                    val curp = array[0]
                    val array2 = array[1].split("|")
                    val apPaterno = array2[0]
                    val apMaterno = array2[1]
                    val nombre = array2[2]

                    // Se sobreescribe la informacion recibida en los campos que se seleccionan
                    edCurp.setText(curp)
                    edNombre.setText(nombre)
                    edPaterno.setText(apPaterno)
                    edMaterno.setText(apMaterno)
                }


        }

        // Si se presiona el boton te manda al URL indicado
        btnCurp.setOnClickListener{
            val url = Uri.parse("https://www.gob.mx/curp/")
            val navegador = Intent(Intent.ACTION_VIEW,url)
            startActivity(navegador)
        }


        // Si el boton de registro es presionado se cambian los campos a MAYUSCULAS para la mejora de procesamiento de datos
        btnRegistrarsee.setOnClickListener{
            val curp = edCurp.text.toString().uppercase()
            val nombre = edNombre.text.toString().uppercase()
            val apellidop = edPaterno.text.toString().uppercase()
            val apellidom = edMaterno.text.toString().uppercase()
            val año = edAño.text.toString()
            val contra = edContrasena.text.toString()
            val condicion = condicion.selectedItem.toString()

            // Se hace el llamado para enviar los datos
            viewModel.enviardatos(curp, nombre,apellidop, apellidom,año,condicion,contra)


        }

    }

    fun registrarObservables(){
        viewModel.response2.observe(this){observes ->
            if (viewModel.response2.value != "NEL"){
                val intent : Intent = Intent(this, LoginView::class.java)
                startActivity(intent)
                finish()
            } else {

                val mensajeError = "No te pudimos registrar :( \n" +
                        "Verifica tus datos"
                val duracion = Toast.LENGTH_LONG

                val toast = Toast.makeText(applicationContext, mensajeError, duracion)
                toast.show()
            }

        }
    }

}