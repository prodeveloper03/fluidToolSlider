package com.codingwithme.fluidslider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.ramotion.fluidslider.FluidSlider

class MainActivity : AppCompatActivity() {

    val max = 100
    val min = 0
    val total = max - min
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val slider = findViewById<FluidSlider>(R.id.fluidSlider)
        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)


        slider.positionListener = {pos -> slider.bubbleText = "${min+(total*pos).toInt()}"}
        slider.position = 0.3f
        slider.startText = "$min"
        slider.endText = "$max"

        button.setOnClickListener{

            val s = slider.bubbleText.toString()
            button.setText(s)

        }

        slider.beginTrackingListener = {textView.visibility = View.INVISIBLE}
        slider.endTrackingListener = {textView.visibility = View.VISIBLE}

    }
}