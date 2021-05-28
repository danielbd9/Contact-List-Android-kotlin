package com.mobile.myappneon.contato

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobile.myappneon.R
import com.mobile.myappneon.contato.adapter.ListaContatoAdapter
import kotlinx.android.synthetic.main.activity_lista_contato.*

class ListaContatoActivity : AppCompatActivity() {

    private val listaContatoAdapter: ListaContatoAdapter = ListaContatoAdapter()

    private lateinit var viewModel: ListaContatoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_contato)

        viewModel = ListaContatoViewModel()

        setupView()
        processParams()
    }

    private fun setupView(){
        ivVoltar.setOnClickListener {
          finish()
        }
    }

    private fun processParams(){
        rcListaContato.adapter = listaContatoAdapter
        rcListaContato.layoutManager = LinearLayoutManager(this)

        listaContatoAdapter.submitList(viewModel.inicializarListaContatos())
    }
}