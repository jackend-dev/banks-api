package br.com.desafiofoton.brasilapibanks.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import br.com.desafiofoton.brasilapibanks.databinding.ActivityBankDetailsBinding
import br.com.desafiofoton.brasilapibanks.model.Bank
import br.com.desafiofoton.brasilapibanks.ui.activity.MainActivity.Companion.CNPJ_SEQ
import br.com.desafiofoton.brasilapibanks.ui.viewmodel.BankDetailsViewModel

import br.com.desafiofoton.brasilapibanks.util.Extensions.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BankDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBankDetailsBinding
    private lateinit var viewModel: BankDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBankDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get(BankDetailsViewModel::class.java)
        val cnpjSeq = intent.getIntExtra(CNPJ_SEQ, -1)

        initViewModel()
        getObserverBank(cnpjSeq)

    }

    private fun setDetail(it: Bank) {
        binding.apply {
            nome.text = it.NomeIf
            nomeAgencia.text = it.NomeAgencia
            complemento.text = it.Complemento
            endereco.text = it.Endereco
        }
    }

    private fun initViewModel() {

        viewModel.getBankObserver().observe(this, Observer {
            if (it != null) {
                setDetail(it)
            } else {
                toast("Erro ao carregar dados")
            }
        })
    }

    private fun getObserverBank(cnpjSequence: Int) {
        viewModel.getBank(cnpjSequence)
    }
}