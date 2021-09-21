package br.com.desafiofoton.brasilapibanks.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import br.com.desafiofoton.brasilapibanks.model.Bank
import br.com.desafiofoton.brasilapibanks.network.ApiService
import br.com.desafiofoton.brasilapibanks.model.ListResults
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) {

    fun makeApiCall(liveDataList: MutableLiveData<List<Bank>>) {
        val call: Call<ListResults> = apiService.getDataApi()
        call?.enqueue(object : Callback<ListResults> {
            override fun onResponse(call: Call<ListResults>, response: Response<ListResults>) {
                liveDataList.postValue(response.body()?.value)
            }

            override fun onFailure(call: Call<ListResults>, t: Throwable) {
                t.message?.let {

                    Log.e("onFailure error", t.message!!)
                }
            }

        })

    }

    fun getAgenciaCall(bankLiveData: MutableLiveData<Bank>, cnpjSequence: Int) {
        val call = apiService.getCnpjBySeq(cnpjSequence)
        call.enqueue(object : Callback<Bank> {
            override fun onResponse(call: Call<Bank>, response: Response<Bank>) {
                bankLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<Bank>, t: Throwable) {
                t.message?.let {

                    Log.e("onFailure error", t.message!!)
                }
            }

        })
    }
}