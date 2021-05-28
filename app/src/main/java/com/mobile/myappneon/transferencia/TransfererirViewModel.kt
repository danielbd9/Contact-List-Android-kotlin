package com.mobile.myappneon.transferencia

import androidx.lifecycle.ViewModel
import java.util.*

internal class TransfererirViewModel : ViewModel() {

    private lateinit var nomeContato: String
    private lateinit var telefoneContato: String
    private lateinit var fotoContato: String
    private lateinit var valorTransferenciaContato: String

    fun setDadosTransferencia(nome: String, telefone: String, foto: String) {
        nomeContato = nome
        telefoneContato = telefone
        fotoContato = foto
    }

    fun setValorTransferencia(valor: String){
        valorTransferenciaContato = valor
    }

    fun getIdTransferencia(min: Int, max: Int): Int {
        return Random().nextInt(max - min + 1) + min
    }

    fun getNome(): String{
        return nomeContato
    }

    fun getTelefone(): String{
       return telefoneContato
    }

    fun getFoto(): String{
        return fotoContato
    }

    fun getValor(): String{
       return valorTransferenciaContato
    }
}