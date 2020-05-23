package mx.edu.ittepic.ladm_u4_practica2_emmanuelhuizar

import android.content.Context
import android.graphics.*
import android.view.View
import android.graphics.BitmapFactory
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

class Lienzo(p:MainActivity) : View(p), SensorEventListener {
    var puntero = p
    var inicio=400
    var col=Color.rgb(103,249,227)
    var col2=Color.rgb(255,0,0)
    var col3=Color.rgb(255,255,0)


    lateinit var sensorManager: SensorManager

    //SOL
    var icono = FiguraGeometrica(BitmapFactory.decodeResource(resources, R.drawable.pajaro), inicio, 700)
    var circulo = FiguraGeometrica(800, 250, 150)
    //PISO
    var cuadrado = FiguraGeometrica(0,1650, 1080, 600)
    //CASA
    var rectangulo = FiguraGeometrica(380, 1380, 600, 350)
    var rectangulo3 = FiguraGeometrica(650, 1550, 110, 180)
    var circulo3 = FiguraGeometrica(510, 1480, 50)
    var circulo6 = FiguraGeometrica(740, 1650, 10)
    //ARBOL
    var rectangulo4 = FiguraGeometrica(110, 1440, 110, 210)
    var circulo4 = FiguraGeometrica(160, 1150, 120)
    var circulo5 = FiguraGeometrica(160, 1350, 140)
    //nuve
    var circulo37 = FiguraGeometrica(160, 520, 120)
    var circulo38 = FiguraGeometrica(325, 400, 120)
    var circulo39 = FiguraGeometrica(500, 500, 120)
    var circulo40 = FiguraGeometrica(355, 600, 110)




    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        var paint = Paint()
        var path =  Path()

        canvas.drawColor(col)

        //Dibujando un círculo rojo con contorno blanco
        paint.color = col2
        circulo.pintar(canvas, paint)
        paint.style = Paint.Style.STROKE
        paint.color = col3
        paint.strokeWidth = 10f
        circulo.pintar(canvas, paint)

        //Dibujando un cuadrado VERDE Contorno AZUL
        paint.style = Paint.Style.FILL
        paint.color = Color.rgb(114,249,103)
        cuadrado.pintar(canvas, paint)

        //Dibujando el rectangulo
        paint.style = Paint.Style.FILL
        paint.color = Color.rgb(120,80,30)
        rectangulo.pintar(canvas, paint)

        paint.style = Paint.Style.FILL
        paint.color = Color.WHITE
        rectangulo3.pintar(canvas, paint)

        //Triangulo
        paint.style = Paint.Style.FILL
        paint.color=Color.rgb(64,57,41)

        path.moveTo(680f, 1100f)
        path.lineTo(1065f, 1380f)
        path.lineTo(295f, 1380f)
        canvas.drawPath(path,paint)

        //--------------ARBOL
        paint.style = Paint.Style.FILL
        paint.color = Color.rgb(95,63,6)
        rectangulo4.pintar(canvas, paint)

        paint.color = Color.rgb(22,111,5)
        circulo4.pintar(canvas, paint)
        circulo5.pintar(canvas, paint)

        //Nuve
        paint.color = Color.WHITE
        circulo39.pintar(canvas, paint)
        circulo37.pintar(canvas, paint)
        circulo38.pintar(canvas, paint)
        circulo40.pintar(canvas, paint)

        paint.color = Color.WHITE
        circulo3.pintar(canvas, paint)

        paint.color = Color.BLACK
        circulo6.pintar(canvas, paint)

        icono.pintar(canvas, paint)
        animarCirculo()

    }
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        var x=event!!.values[0].toInt()*10
        //puntero.setTitle(""+event!!.values[0].toInt()+"             w: "+width+"h: "+height+"I: "+inicio)

        if (event.sensor.type==8){
            if ( event!!.values[0].toInt()==0){
                col=Color.rgb(0,0,0)
                col2=Color.rgb(214,214,214)
                col3=Color.rgb(255,255,255)
            }
            if ( event!!.values[0].toInt()==5){
                col=Color.rgb(103,249,227)
                col2=Color.rgb(255,0,0)
                col3=Color.rgb(255,255,0)

            }
        }
        if(event.sensor.type==1){
            if(inicio>=0 && event!!.values[0].toInt()>0){
                inicio=inicio-x
            }
            if(inicio<=(width-250) && event!!.values[0].toInt()<0){
                inicio=inicio+(-x)
            }
        }
    }

    fun animarCirculo() {
        this.sensorManager =context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY), SensorManager.SENSOR_DELAY_NORMAL)
        icono = FiguraGeometrica(BitmapFactory.decodeResource(resources, R.drawable.pajaro), inicio, 700)
        invalidate()
    }
}