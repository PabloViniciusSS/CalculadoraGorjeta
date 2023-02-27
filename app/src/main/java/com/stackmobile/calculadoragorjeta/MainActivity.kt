package com.stackmobile.calculadoragorjeta

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.stackmobile.calculadoragorjeta.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

     private lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCalcular.setOnClickListener { calculateTip() }

        }

        fun calculateTip() {

            val stringInTextField = binding.costOfService.text.toString()
            val cost = stringInTextField.toDoubleOrNull()

            if (cost == null) {
                binding.tipResult.text = ""
                return
            }


            val selectId = binding.tipOptions.checkedRadioButtonId

                val tipPercentage = when (selectId) {
                    R.id.option_twenty_percent -> 0.20
                    R.id.option_fifteen_percent -> 0.15
                    else -> 0.10
                }
                var tip = tipPercentage * cost
                if ( binding.roundUpSwitch.isChecked) {
                    tip = kotlin.math.ceil(tip)
                }

                val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
                binding.tipResult.text = getString(R.string.tip_amount, formattedTip)


        }

}