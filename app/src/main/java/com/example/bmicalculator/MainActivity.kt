package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate.setOnClickListener(){

            val weight: Double = txtWeight.text.toString().toDouble()
            val height: Double = txtHeight.text.toString().toDouble()

            val bmi: Double = weight / (height * height)

            //todo:: display image & bmi result
            val result:String

            if(bmi >=25) {
                result = "OVER"
                imgBMI.setImageResource(R.drawable.over)
            }
            else if(bmi <= 18.5){
                result = "UNDER"
                imgBMI.setImageResource(R.drawable.under)
            }
            else{
                result = "NORMAL"
                imgBMI.setImageResource(R.drawable.normal)
            }
            txtBMI.text = "BMI: %.2f (%s)".format(bmi, result)
        }


        btnReset.setOnClickListener(){
            //todo:: clear inputs & result
            txtBMI.setText("")
            txtHeight.setText("")
            txtWeight.setText("")

            //todo:: clear image
            imgBMI.setImageResource(R.drawable.empty)

            txtWeight.requestFocus()
        }

    }
}
