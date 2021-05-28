package com.mobile.myappneon.main

import androidx.lifecycle.ViewModel
import java.util.*

internal class MainViewModel : ViewModel() {
    fun gerarToken(): String{
         return UUID.randomUUID().toString()
    }

    fun getIdTransferencia(min: Int, max: Int): Int {
        return Random().nextInt(max - min + 1) + min
    }
}