package br.com.desafiofoton.brasilapibanks.ui.activity


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.desafiofoton.brasilapibanks.databinding.ActivityMainBinding
import br.com.desafiofoton.brasilapibanks.ui.adapter.BankViewAdapter
import br.com.desafiofoton.brasilapibanks.ui.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var bankAdapter: BankViewAdapter
    private lateinit var viewModel: MainActivityViewModel

    companion object {
        const val CNPJ_SEQ = "br.com.desafiofoton.brasilapibanks.ui.activity.MainActivity.CNPJ_SEQ"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initRvListBanks()
        initViewModel()

    }

    private fun initRvListBanks() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        rv_list_banks.layoutManager = LinearLayoutManager(this)

        bankAdapter = BankViewAdapter {
            val intent = Intent(this, BankDetailsActivity::class.java)
            intent.putExtra(CNPJ_SEQ, it)
            startActivity(intent)
        }
        binding.rvListBanks.adapter = bankAdapter
    }

    private fun initViewModel() {

        viewModel.getLiveDataObserver().observe(this, Observer {
            if (it != null) {
                bankAdapter.addItems(it)
            }
        })
        viewModel.getListBanks()
    }


}