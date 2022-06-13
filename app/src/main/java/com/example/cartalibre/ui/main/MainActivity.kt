package com.example.cartalibre.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cartalibre.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mainViewModel.mutableTotalDone.observe(this) { mutableTotal ->
            mainBinding.resultadoTextView4.text = mutableTotal.toString()
        }

        fun checkSpinners() {
            mainBinding.martiniCheckBox.isChecked = mainBinding.martiniSpinner.selectedItem != 0
            mainBinding.cubalibreCheckBox2.isChecked = mainBinding.cubalibreSpinner2.selectedItem != 0
            mainBinding.mojitoCheckBox3.isChecked = mainBinding.mojitoSpinner3.selectedItem != 0
            mainBinding.gintonicCheckBox.isChecked = mainBinding.gintonicSpinner4.selectedItem != 0
        }
        //ESTE COMANDO DA ERROR
        //Prueba de Primer Spinner
        //mainBinding.martiniSpinner.setOnClickListener {
        //    checkSpinners()
        //}

        mainBinding.pedirButton.setOnClickListener {
            if (mainBinding.martiniCheckBox.isChecked) {
                val cantidad_mar = mainBinding.martiniSpinner.selectedItem.toString().toInt()
                mainViewModel.calcularTotalProducto(1, cantidad_mar)
            }
            //else total_martini = 0

            if (mainBinding.cubalibreCheckBox2.isChecked) {
                val cantidad_cuba = mainBinding.cubalibreSpinner2.selectedItem.toString().toInt()
                mainViewModel.calcularTotalProducto(2, cantidad_cuba)

            }
            //else total_cuba = 0

            if (mainBinding.mojitoCheckBox3.isChecked) {
                val cantidad_mojito = mainBinding.mojitoSpinner3.selectedItem.toString().toInt()
                mainViewModel.calcularTotalProducto(3, cantidad_mojito)

            }
            //else total_mojito = 0

            if (mainBinding.gintonicCheckBox.isChecked) {
                val cantidad_gintonic = mainBinding.gintonicSpinner4.selectedItem.toString().toInt()
                mainViewModel.calcularTotalProducto(4, cantidad_gintonic)
            }
            //else total_gintonic = 0

            mainViewModel.calcularTotalCuenta()
        }
        mainBinding.cancelButton2.setOnClickListener {
            mainViewModel.borrarTotalCuenta()
            mainBinding.martiniCheckBox.isChecked = false
            mainBinding.cubalibreCheckBox2.isChecked = false
            mainBinding.mojitoCheckBox3.isChecked = false
            mainBinding.gintonicCheckBox.isChecked = false
            mainBinding.martiniSpinner.setSelection(0)
            mainBinding.cubalibreSpinner2.setSelection(0)
            mainBinding.mojitoSpinner3.setSelection(0)
            mainBinding.gintonicSpinner4.setSelection(0)
        }

    }


}