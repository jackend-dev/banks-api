package br.com.desafiofoton.brasilapibanks.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.desafiofoton.brasilapibanks.model.Bank
import br.com.desafiofoton.brasilapibanks.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BankDetailsViewModel @Inject constructor(private val repository: ApiRepository): ViewModel() {
    private val bankLiveData: MutableLiveData<Bank> = MutableLiveData()

    fun getBankObserver(): MutableLiveData<Bank> {
        return bankLiveData
    }

    fun getBank(cnpjSeq: Int) {
        repository.getAgenciaCall(bankLiveData, cnpjSeq)
    }
}