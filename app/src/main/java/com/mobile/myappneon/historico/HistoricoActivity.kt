package com.mobile.myappneon.historico

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.mobile.myappneon.R
import com.mobile.myappneon.historico.adapter.HistoricoContatoAdapter
import com.mobile.myappneon.model.Transferencia
import kotlinx.android.synthetic.main.activity_historico.*


class HistoricoActivity : AppCompatActivity() {

    private lateinit var viewModel: HistoricoViewModel

    private val listaHistoricoContatoAdapter: HistoricoContatoAdapter = HistoricoContatoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico)

        viewModel = HistoricoViewModel()

        setupView()
        processParams()
    }

    private fun setupView(){
        ivVoltar.setOnClickListener {
            finish()
        }
    }

    private fun processParams(){
        rcListaContatoHistorico.adapter = listaHistoricoContatoAdapter
        rcListaContatoHistorico.layoutManager = LinearLayoutManager(this)

        val lista = intent.getParcelableArrayListExtra(PARAM_TRANSFERENCIA) ?: emptyList<Transferencia>()
        listaHistoricoContatoAdapter.submitList(lista)

        exibirGrafico(lista)
    }

    private fun exibirGrafico(
        listaTransferencia: List<Transferencia>
    ) {
        val barChart = findViewById<BarChart>(R.id.barChart)
        barChart.setBorderColor(R.color.white)
        barChart.axisLeft.textColor = Color.WHITE
        barChart.axisRight.textColor = Color.WHITE
        barChart.legend.textColor = Color.WHITE
        barChart.xAxis.textColor = Color.WHITE

        val transfer = ArrayList<BarEntry>()

        val valor = listaTransferencia[0].valor.toFloat()

        transfer.add(BarEntry(1f, floatArrayOf(valor, valor)))

        val barDataSet = BarDataSet(transfer, listaTransferencia[0].nome)
        barDataSet.color = ContextCompat.getColor(this, android.R.color.holo_blue_light)
        barDataSet.barBorderColor = Color.WHITE
        barDataSet.valueTextColor = Color.WHITE
        barDataSet.valueTextColor = Color.WHITE
        barDataSet.barShadowColor = Color.WHITE
        barDataSet.valueTextSize = 16f
        barDataSet.barBorderWidth = 1f

        val barData = BarData(barDataSet)
        barData.setValueTextColor(Color.WHITE)

        barChart.setFitBars(true)
        barChart.data = barData
        barChart.description.text = "Valor"
        barChart.description.textColor = Color.WHITE
        barChart.legend.textColor = Color.WHITE
    }

    companion object{
        private const val PARAM_TRANSFERENCIA = "PARAM_TRANSFERENCIA"
    }
}