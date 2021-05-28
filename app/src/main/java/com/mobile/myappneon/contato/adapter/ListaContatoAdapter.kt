package com.mobile.myappneon.contato.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.avatarfirst.avatargenlib.AvatarConstants
import com.avatarfirst.avatargenlib.AvatarGenerator
import com.bumptech.glide.Glide
import com.mobile.myappneon.R
import com.mobile.myappneon.transferencia.TransferirSheetFragment
import com.mobile.myappneon.model.Contato
import kotlinx.android.synthetic.main.item_lista_contato.view.*

internal class ListaContatoAdapter :
   ListAdapter<Contato, ListaContatoAdapter.ViewHolder>(DIFF_CALLBACK) {

    private val PARAM_NOME = "PARAM_NOME"
    private val PARAM_TELEFONE = "PARAM_TELEFONE"
    private val PARAM_FOTO = "PARAM_FOTO"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_lista_contato, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.itemView) {

            preencherInformacoes(item)
            carregarImagemAvatar(item)
            eventoClick(item)
        }
    }

    private fun View.eventoClick(item: Contato) {
        setOnClickListener {
            abrirTransferenciaSheetView(item)
        }
    }

    private fun View.abrirTransferenciaSheetView(item: Contato) {
        val bottomSheetFragment = TransferirSheetFragment()
        val bundle = Bundle()
        bundle.putString(PARAM_NOME, item.nome)
        bundle.putString(PARAM_TELEFONE, item.telefone)
        bundle.putString(PARAM_FOTO, item.foto)
        bottomSheetFragment.arguments = bundle
        bottomSheetFragment.show((context as FragmentActivity).supportFragmentManager, "transferencia")
    }

    private fun View.carregarImagemAvatar(item: Contato) {
        Glide.with(this)
                .load(item.foto)
                .placeholder(AvatarGenerator.avatarImage(context, 500, AvatarConstants.CIRCLE, item.nome))
                .into(ivContatoAvatar)
    }

    private fun View.preencherInformacoes(item: Contato) {
        tvNome.text = item.nome
        tvTelefone.text = item.telefone
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}

private object DIFF_CALLBACK : DiffUtil.ItemCallback<Contato>() {
    override fun areItemsTheSame(oldItem: Contato, newItem: Contato): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Contato, newItem: Contato): Boolean {
        return oldItem == newItem
    }
}
