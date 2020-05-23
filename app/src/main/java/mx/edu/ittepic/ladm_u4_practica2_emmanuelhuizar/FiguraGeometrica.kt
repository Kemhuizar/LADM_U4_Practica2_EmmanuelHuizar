package mx.edu.ittepic.ladm_u4_practica2_emmanuelhuizar

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.os.CountDownTimer
import java.util.*

class FiguraGeometrica() {
    var x = 0f
    var y = 0f
    var tipo = 1 //1 circulo 2 rectangulo
    var radio = 0f
    var ancho = 0f
    var alto = 0f
    var incY = 1
    var imagen: Bitmap?=null

    var incX=1f

    constructor(x:Int, y:Int, radio:Int) : this(){
        this.x = x.toFloat()
        this.y = y.toFloat()
        this.radio = radio.toFloat()
    }

    constructor(bitmap: Bitmap, x:Int, y:Int) : this(){
        imagen=bitmap
        this.x = x.toFloat()
        this.y = y.toFloat()
        tipo = 3
        ancho=imagen!!.width.toFloat()
        alto=imagen!!.height.toFloat()
    }

    constructor(x:Int, y:Int, ancho:Int, alto:Int) : this(){
        this.x = x.toFloat()
        this.y = y.toFloat()
        this.ancho = ancho.toFloat()
        this.alto = alto.toFloat()
        tipo = 2
    }

    fun pintar(c: Canvas, p: Paint){
        when(tipo){
            1->{
                c.drawCircle(x,y,radio,p)
            }
            2->{
                c.drawRect(x,y,x+ancho,y+alto,p)
            }
            3->{
                c.drawBitmap(imagen!!,x,y,p)
            }
        }
    }

    fun rebote(ancho:Int, alto:Int){
        x+= incX
        if(x<=0 || x>=ancho-radio*2){
            incX *= -1
        }
    }

}