package com.mobile.myappneon.transferencia

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.avatarfirst.avatargenlib.AvatarConstants
import com.avatarfirst.avatargenlib.AvatarGenerator
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mobile.myappneon.R
import com.mobile.myappneon.historico.HistoricoActivity
import com.mobile.myappneon.model.Transferencia
import kotlinx.android.synthetic.main.transferencia_sheet_view.*

class TransferirSheetFragment : BottomSheetDialogFragment() {

    private lateinit var viewModel: TransfererirViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
      return inflater.inflate(R.layout.transferencia_sheet_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = TransfererirViewModel()

        setupView()
        processParams()
    }

    private fun setupView(){
        btnEnviarDinheiro.setOnClickListener {
            val valor = etValor.text
            viewModel.setValorTransferencia(valor.toString())

            irParaHistorico()
        }
    }

    private fun irParaHistorico() {
        val intent = Intent(requireContext(), HistoricoActivity::class.java)
        intent.putParcelableArrayListExtra(PARAM_TRANSFERENCIA, arrayListOf(*getListaTransferencias().toTypedArray()))
        startActivity(intent)
    }

    private fun getListaTransferencias(): ArrayList<Transferencia> {
        return arrayListOf(Transferencia(viewModel.getIdTransferencia(1,10), viewModel.getNome(),
            viewModel.getTelefone(),
            viewModel.getFoto(),
            viewModel.getValor()))
    }

    private fun processParams(){
        val nome = arguments?.getString(PARAM_NOME).toString()
        val telefone = arguments?.getString(PARAM_TELEFONE).toString()
        val foto = arguments?.getString(PARAM_FOTO).toString()

        viewModel.setDadosTransferencia(nome,telefone,foto)

        preencherInformacoes(nome, telefone)
        carregarImagemAvatar(foto, nome)
    }

    private fun carregarImagemAvatar(foto: String, nome: String) {
        Glide.with(this)
                .load(foto)
                .placeholder(AvatarGenerator.avatarImage(requireContext(), 500, AvatarConstants.CIRCLE, nome.toString()))
                .into(ivAvatar)
    }

    private fun preencherInformacoes(nome: String, telefone: String) {
        tvNomeSheet.text = nome
        tvTelefoneSheet.text = telefone
    }

    companion object{
        private const val PARAM_NOME = "PARAM_NOME"
        private const val PARAM_TELEFONE = "PARAM_TELEFONE"
        private const val PARAM_FOTO = "PARAM_FOTO"
        private const val PARAM_TRANSFERENCIA = "PARAM_TRANSFERENCIA"
    }
}