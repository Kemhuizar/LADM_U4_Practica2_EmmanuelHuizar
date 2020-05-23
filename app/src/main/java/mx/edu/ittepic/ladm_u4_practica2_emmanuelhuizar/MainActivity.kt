package mx.edu.ittepic.ladm_u4_practica2_emmanuelhuizar

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(){
    var lienzo  : Lienzo ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lienzo = Lienzo(this)
        setContentView(lienzo!!)
        setResult(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
    }

}
