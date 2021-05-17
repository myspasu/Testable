package com.example.anastasio_salas_ayonbenitez_1ra_aplicacion_u3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btnNextP.setOnClickListener{
            val passport : Intent = Intent(this,Activity2::class.java)
            if (!verif_course() && !verif_text()){
                Toast.makeText(this, "Ingresa los datos indicados", Toast.LENGTH_SHORT).show()
            }
            else if (!verif_text()){
                Toast.makeText(this, "Ingresa el precio a pagar", Toast.LENGTH_SHORT).show()
                etPrecio.requestFocus()
            }
            else if (!verif_course()){
                Toast.makeText(this, "Selecciona un curso", Toast.LENGTH_SHORT).show()
            }
            else{
                try {

                    var price: String = etPrecio.text.toString()
                    if (price.toInt() < 1) {
                        Toast.makeText(this, "Ingrecia un precio mayor a 0", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        var chosen: String = checked()
                        var off10p: Double = 0.0
                        var off05p: Double = 0.0
                        var total_off: Double = 0.0

                        if (cb5.isChecked()) {
                            total_off += 5
                            off05p = price.toDouble() * .05
                        }
                        if (cb10.isChecked()) {
                            total_off += 10
                            off10p = price.toDouble() * .10
                        }

                        passport.putExtra("price1", price)
                        passport.putExtra("chosen1", chosen)
                        passport.putExtra("totaloff1", total_off.toString())
                        passport.putExtra("off05p1", off05p.toString())
                        passport.putExtra("off10p1", off10p.toString())
                        passport.putExtra("trueoff", (price.toDouble() *  total_off/100).toString())

                        startActivity(passport)

                    }
                }
                catch (messaege: NumberFormatException){
                    Toast.makeText(this, "there was an error", Toast.LENGTH_SHORT).show()
                }
            }

        }


        btnGoOut.setOnClickListener{
            this.finish()
        }

        btnClear.setOnClickListener{
            etPrecio.setText("")
            Opcion1.isChecked = false
            Opcion2.isChecked = false
            Opcion3.isChecked = false
            cb5.isChecked = false
            cb10.isChecked = false
            etPrecio.requestFocus()

        }

    }

    fun verif_text():Boolean{
        var flag : Boolean = false
        if (etPrecio.text.toString().isNotEmpty()) flag = true
        return flag
    }
    fun verif_course():Boolean{
        var flag : Boolean = false
        if (Opcion1.isChecked() || Opcion2.isChecked() || Opcion3.isChecked()) flag = true
        return flag
    }
    fun checked() : String{
        var responses : String = "None"
        when {
            Opcion1.isChecked() -> responses = "C++"
            Opcion2.isChecked() -> responses = "Sharp"
            Opcion3.isChecked() -> responses = "Android Studio"
        }
        return responses
    }
}

