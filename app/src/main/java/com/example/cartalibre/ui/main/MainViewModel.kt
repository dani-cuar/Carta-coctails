package com.example.cartalibre.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var totalMartini = 0
    private var totalCubaLibre = 0
    private var totalMojito = 0
    private var totalGintonic = 0

    private var price_martini = 25000
    private var price_cuba_libre = 10000
    private var price_mojito = 20000
    private var price_gintonic = 25000



    private val mutableTotal: MutableLiveData<Int> = MutableLiveData()
    val mutableTotalDone: LiveData<Int> = mutableTotal



    fun calcularTotalProducto(product: Int, quantity: Int){
        when(product){
            1 -> totalMartini = price_martini*quantity
            2 -> totalCubaLibre = price_cuba_libre*quantity
            3 -> totalMojito = price_mojito*quantity
            4 -> totalGintonic = price_gintonic*quantity
        }
    }
    fun calcularTotalCuenta(){
        mutableTotal.value = totalMartini + totalCubaLibre + totalMojito + totalGintonic
    }
    fun borrarTotalCuenta(){
        mutableTotal.value = 0
    }
}