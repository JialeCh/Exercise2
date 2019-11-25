package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener {
            calculation(it)
        }

        findViewById<Button>(R.id.buttonReset).setOnClickListener {
            reset(it)
        }
    }




    private fun calculation(view: View) {

        val weight = editTextWeight.text.toString()
        val height: Double = editTextHeight.text.toString().toDouble()
        val BMI : Double = weight.toDouble() / ( height * height)




        if(BMI < 18.5){
            textViewBMI.text ="BMI :%.2f( under) ".format(BMI)
            imageViewProfile.setImageResource(R.drawable.under )
        }
        else if(BMI < 24.9){
            textViewBMI.text ="BMI :%.2f ( normal) ".format(BMI)
            imageViewProfile.setImageResource(R.drawable.normal)
        }
        else{
            textViewBMI.text ="BMI :%.2f( over)".format(BMI)
            imageViewProfile.setImageResource(R.drawable.over)
        }

        //app:srcCompat="@drawable/empty" />

    }
    private fun reset(view: View) {
        imageViewProfile.setImageResource(R.drawable.empty)
        textViewBMI.text = ""
        editTextWeight.text.clear()
        editTextHeight.text.clear()
        editTextWeight.requestFocus()
    }

}
