package br.com.desafiofoton.brasilapibanks.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.desafiofoton.brasilapibanks.model.Bank
import br.com.desafiofoton.brasilapibanks.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: ApiRepository): ViewModel() {
    private var liveDataList: MutableLiveData<List<Bank>> = MutableLiveData()

    fun getLiveDataObserver(): MutableLiveData<List<Bank>> {
        return liveDataList
    }

    fun getListBanks() {
        repository.makeApiCall(liveDataList)
    }


}