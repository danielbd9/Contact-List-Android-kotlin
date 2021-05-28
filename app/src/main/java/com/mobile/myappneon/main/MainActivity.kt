package com.mobile.myappneon.main

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
import androidx.appcompat.app.AppCompatActivity
import com.avatarfirst.avatargenlib.AvatarConstants
import com.avatarfirst.avatargenlib.AvatarGenerator
import com.bumptech.glide.Glide
import com.mobile.myappneon.R
import com.mobile.myappneon.contato.ListaContatoActivity
import com.mobile.myappneon.historico.HistoricoActivity
import com.mobile.myappneon.model.Transferencia
import com.mobile.myappneon.shared.Authentication
import com.mobile.myappneon.transferencia.TransferirSheetFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.window.setFlags(FLAG_TRANSLUCENT_STATUS, FLAG_TRANSLUCENT_STATUS)

        viewModel = MainViewModel()

        init()
        setupView()
    }

    private fun init(){
        val foto = "https://media-exp1.licdn.com/dms/image/C4E03AQF6-yeVsEiW-w/profile-displayphoto-shrink_400_400/0/1516649202422?e=1616025600&v=beta&t=MzTp8JwAZ5XoNskPiG_2hqxkHOqsUS3ptW8gYRUDwuU"
        val nome = "Daniel Diniz"
        val email = "danielbd9@hotmail.com"

        val shared = salvarInformacoesUsuario(nome, email)
        preencherInformacoes(shared)
        carregarImagemAvatar(foto)
    }

    private fun preencherInformacoes(shared: Authentication?) {
        tvNome.text = shared?.getData(PARAM_KEY_NOME)
        tvEmail.text = shared?.getData(PARAM_KEY_EMAIL)
    }

    private fun carregarImagemAvatar(foto: String) {
        Glide.with(this)
                .load(foto)
                .placeholder(AvatarGenerator.avatarImage(this, 500, AvatarConstants.CIRCLE, "Daniel"))
                .into(ivAvatar)
    }

    private fun salvarInformacoesUsuario(nome: String, email: String): Authentication? {
        val shared = Authentication.getInstance(this)
        shared?.saveData(PARAM_KEY_TOKEN, viewModel.gerarToken())
        shared?.saveData(PARAM_KEY_NOME, nome)
        shared?.saveData(PARAM_KEY_EMAIL, email)
        return shared
    }

    private fun setupView(){
        btnEnviarDinheiro.setOnClickListener {
            irParaListaContato()
        }

        btnVerHistorico.setOnClickListener {
            irParaHistorico()
        }
    }

    private fun irParaHistorico() {
        val intent = Intent(this, HistoricoActivity::class.java)
        intent.putParcelableArrayListExtra(PARAM_TRANSFERENCIA, arrayListOf(*getListaTransferencias().toTypedArray()))
        startActivity(intent)
    }

    private fun irParaListaContato() {
        val intent = Intent(this, ListaContatoActivity::class.java)
        startActivity(intent)
    }

    private fun getListaTransferencias(): ArrayList<Transferencia> {
        return arrayListOf(
            Transferencia(viewModel.getIdTransferencia(1,10), "Nome Mock",
            "(31)9999-99999",
            "",
            "150.00")
        )
    }

    companion object{
        private const val PARAM_KEY_TOKEN = "PARAM_KEY_TOKEN"
        private const val PARAM_KEY_NOME = "PARAM_KEY_NOME"
        private const val PARAM_KEY_EMAIL = "PARAM_KEY_EMAIL"
        
        private const val PARAM_TRANSFERENCIA = "PARAM_TRANSFERENCIA"
    }
}