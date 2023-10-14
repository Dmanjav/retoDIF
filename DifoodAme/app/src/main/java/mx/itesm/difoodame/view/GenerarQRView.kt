package mx.itesm.difoodame.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import com.google.zxing.qrcode.QRCodeWriter
import mx.itesm.difoodame.R

class GenerarQRView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generar_qrview)
        iniciarEventos()
    }

    fun iniciarEventos(){
        val sharedPref = getSharedPreferences("mySharedPrefs", Context.MODE_PRIVATE)
        val curp = sharedPref.getString("CurpUsuario", "")
        val qrgenerado = generarQR(curp.toString())
        val imgQR : ImageView = findViewById(R.id.imageViewQR)
        imgQR.setImageBitmap(qrgenerado)
    }

    private fun generarQR(curp: String): Bitmap? {
        val qr = QRCodeWriter()
        try {
            val matriz : BitMatrix = qr.encode(curp, BarcodeFormat.QR_CODE, 512, 512)
            val ancho = matriz.width
            val alto = matriz.height
            val bitmap = Bitmap.createBitmap(ancho, alto, Bitmap.Config.RGB_565)
            for (x in 0 until  ancho){
                for (y in 0 until  alto){
                    bitmap.setPixel(x,y, if ( matriz[x,y]) Color.BLACK else Color.WHITE)
                }
            }
            return  bitmap

        } catch (e: WriterException){
            e.printStackTrace()
            return null
        }
    }
}