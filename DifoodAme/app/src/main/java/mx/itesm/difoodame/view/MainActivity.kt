package mx.itesm.difoodame.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.Uri
import android.print.PrintJobInfo
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.gms.common.moduleinstall.InstallStatusListener
import com.google.android.gms.common.moduleinstall.ModuleInstall
import com.google.android.gms.common.moduleinstall.ModuleInstallRequest
import com.google.android.gms.common.moduleinstall.ModuleInstallStatusUpdate
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning
import mx.itesm.difoodame.R

/**
 * @author Andrés Iván Rodríguez Méndez
 * Esta es la vista de la pantalla de inicio
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        animaciontext()

        //Verifica si hay conexion a internet en el dispositivo
        if (isInternetAvailable(this    )){
            iniciarEvento()
            verificarQR()
        } else{
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Error en conexión")
                .setMessage("Verifica tu conexión a internet")
                .setPositiveButton("OK") { dialog, _ ->
                    // Cerrar el AlertDialog y comenzar la actividad MainActivity
                    dialog.dismiss()
                    val enviar = Intent(this, MainActivity::class.java)
                    startActivity(enviar)
                }
                .show()
        }
    }


    fun iniciarEvento(){
        // Variable para la animacion
        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.rotate)

        // Se dan de alta los botones
        val btnLogin: Button = findViewById(R.id.btnLogin)
        val btnRegistrarse: Button = findViewById(R.id.btnRegistrarse)
        val btnInfo : FloatingActionButton = findViewById(R.id.btnInfo)

        // Se dan de alta los setOnClickListener
        btnLogin.setOnClickListener {
            // Cambio de pantalla
            val intent: Intent = Intent(this, LoginView::class.java)
            startActivity(intent)
            finish()
        }

        btnInfo.setOnClickListener{
            val url = Uri.parse("https://drive.google.com/file/d/1trV4WMy_MX4eKSeJGZHAq6YsUPUHtA1Y/view?usp=share_link")
            val navegador = Intent(Intent.ACTION_VIEW,url)
            startActivity(navegador)

        }

        btnRegistrarse.setOnClickListener{
            // Cambio de pantalla
            val intent: Intent = Intent(this, RegistrarseView::class.java)
            startActivity(intent)
            finish()

        }

        // Se inician las animaciones
        btnRegistrarse.startAnimation(animation)
        btnLogin.startAnimation(animation)

    }
    fun animaciontext(){
        // Cosas de animacion
        val imageView = findViewById<ImageView>(R.id.imgLogo)
        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.rotate)
        val txv = findViewById<TextView>(R.id.textBienvenidos)
        imageView.startAnimation(animation)
        txv.startAnimation(animation)
    }

    fun isInternetAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        // Comprueba la información de la red activa
        val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo

        return networkInfo?.isConnected == true
    }

    //Instala modulo para el QR

    private fun verificarQR()
    {
        val moduleInstallClient = ModuleInstall.getClient(this)
        val optionalModuleApi = GmsBarcodeScanning.getClient(this)

        moduleInstallClient
            .areModulesAvailable(optionalModuleApi)
            .addOnSuccessListener {
                if (it.areModulesAvailable()) {
                    println("<Si está instalado")
                    //escanearQR()
                } else {
                    println("No está instalado")
                    instalarModulo()
                }
            }
            .addOnFailureListener {
                println("Error al verificar módulo")
            }

    }

    private fun instalarModulo() {
        val moduleInstallClient = ModuleInstall.getClient(this)
        val optionalModuleApi = GmsBarcodeScanning.getClient(this)

        val moduleInstallRequest =
            ModuleInstallRequest.newBuilder()
                .addApi(optionalModuleApi)
                .setListener(listener)
                .build()

        moduleInstallClient
            .installModules(moduleInstallRequest)
            .addOnSuccessListener {
                if (it.areModulesAlreadyInstalled()) {
                    // Modules are already installed when the request is sent.
                    println("I N S T A L A N D O ......")
                }
            }
            .addOnFailureListener {
                println("NO SE PUEDE INSTALAR")

            }
    }





    inner class ModuleInstallProgressListener : InstallStatusListener {
        override fun onInstallStatusUpdated(update: ModuleInstallStatusUpdate) {
            // Progress info is only set when modules are in the progress of downloading.
            update.progressInfo?.let {
                val progress = (it.bytesDownloaded * 100 / it.totalBytesToDownload).toInt()
                // Set the progress for the progress bar.
                //progressBar.setProgress(progress)
                println(progress)
                if(progress == 100)
                {
                    Log.d("API_TEST", "Modulo Instalado")

                }
            }

            if (isTerminateState(update.installState)) {
                //moduleInstallClient.unregisterListener(this)
            }
        }
        fun isTerminateState(@ModuleInstallStatusUpdate.InstallState state: Int): Boolean {
            return state == PrintJobInfo.STATE_CANCELED || state == PrintJobInfo.STATE_COMPLETED || state == PrintJobInfo.STATE_FAILED
        }
    }

    val listener = ModuleInstallProgressListener()
}