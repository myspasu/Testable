package com.example.anastasio_salas_ayonbenitez_1ra_aplicacion_u3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_2.*
import kotlin.math.cos

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        var prices : String? = this.intent.getStringExtra("price1")
        var chosens : String? = this.intent.getStringExtra("chosen1")
        var totaloffs : String? = this.intent.getStringExtra("totaloff1")
        var off05ps : String? = this.intent.getStringExtra("off05p1")
        var off10ps : String? = this.intent.getStringExtra("off10p1")
        var trueoff1:String? = this.intent.getStringExtra("trueoff")

        var prince : Double = prices.toString().toDouble()//precio total
        val totaldiscount : Double = trueoff1.toString().toDouble()//Valor monetario del descuento
        chosens = chosens.toString()
        val p10 : Double = off10ps.toString().toDouble()
        val p05 : Double = off05ps.toString().toDouble()
        val totaly: Double = totaloffs.toString().toDouble()//Valor Porcentual del descuento
        prince-=totaldiscount

        tvresult.append("Curso: $chosens\n")
        tvresult.append("Precio: $${"%.2f".format(prince)}\n")
        tvresult.append("Descuento 1 (5%): $${"%.2f".format(p05)}\n")
        tvresult.append("Descuento 2 (%10): $${"%.2f".format(p10)}\n")
        tvresult.append("Descuento Total (%${"%.0f".format(totaly)}): $${"%.2f".format(totaldiscount)}\n")
        tvresult.append("Precio total: $${"%.2f".format(prince)}")


        btnregresar.setOnClickListener(){
            this.finish()
        }
    }
}