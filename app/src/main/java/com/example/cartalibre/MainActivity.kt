package com.example.cartalibre

import android.app.Activity
import android.os.Bundle
import com.example.cartalibre.databinding.ActivityMainBinding

class MainActivity : Activity() {

    private lateinit var mainBinding: ActivityMainBinding
    private var total: Int = 0
    private var total_martini: Int = 0
    private var total_cuba: Int = 0
    private var total_mojito: Int = 0
    private var total_gintonic: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        with(mainBinding){
            pedirButton.setOnClickListener{
                if(martiniCheckBox.isChecked) {
                    val cantidad_mar = martiniSpinner.selectedItem.toString().toInt()
                    total_martini = 25000 * cantidad_mar
                }
                else total_martini = 0

                if (cubalibreCheckBox2.isChecked) {
                    val cantidad_cuba = cubalibreSpinner2.selectedItem.toString().toInt()
                    total_cuba = 10000 * cantidad_cuba
                }
                else total_cuba = 0

                if (mojitoCheckBox3.isChecked) {
                    val cantidad_mojito = mojitoSpinner3.selectedItem.toString().toInt()
                    total_mojito = 20000 * cantidad_mojito
                }
                else total_mojito = 0

                if (gintonicCheckBox.isChecked) {
                    val cantidad_gintonic = gintonicSpinner4.selectedItem.toString().toInt()
                    total_gintonic = 25000 * cantidad_gintonic
                }
                else total_gintonic = 0

                var salida = total_martini + total_cuba + total_mojito + total_gintonic
                resultadoTextView4.text = salida.toString()
            }
            cancelButton2.setOnClickListener{
                total = 0
                val salida = total.toString()
                resultadoTextView4.text = salida
                martiniCheckBox.isChecked = false
                cubalibreCheckBox2.isChecked = false
                mojitoCheckBox3.isChecked = false
                gintonicCheckBox.isChecked =false
                martiniSpinner.setSelection(0)
                cubalibreSpinner2.setSelection(0)
                mojitoSpinner3.setSelection(0)
                gintonicSpinner4.setSelection(0)
            }
        }
    }
}