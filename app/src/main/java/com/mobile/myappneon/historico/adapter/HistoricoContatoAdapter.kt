package com.mobile.myappneon.historico.adapter

import android.provider.Settings.System.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.avatarfirst.avatargenlib.AvatarConstants
import com.avatarfirst.avatargenlib.AvatarGenerator
import com.bumptech.glide.Glide
import com.mobile.myappneon.R
import com.mobile.myappneon.model.Transferencia
import kotlinx.android.synthetic.main.item_lista_contato.view.*

internal class HistoricoContatoAdapter :
        ListAdapter<Transferencia, HistoricoContatoAdapter.ViewHolder>(DIFF_CALLBACK) {

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
        }
    }

    private fun View.carregarImagemAvatar(item: Transferencia) {
        Glide.with(this)
                .load(item.foto)
                .placeholder(AvatarGenerator.avatarImage(context, 500, AvatarConstants.CIRCLE, item.nome))
                .into(ivContatoAvatar)
    }

    private fun View.preencherInformacoes(item: Transferencia) {
        tvNome.text = item.nome
        tvTelefone.text = item.telefone
        tvValor.text = resources.getString(R.string.app_valor,item.valor)

        tvValor.visibility = View.VISIBLE
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}

private object DIFF_CALLBACK : DiffUtil.ItemCallback<Transferencia>() {
    override fun areItemsTheSame(oldItem: Transferencia, newItem: Transferencia): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Transferencia, newItem: Transferencia): Boolean {
        return oldItem == newItem
    }
}