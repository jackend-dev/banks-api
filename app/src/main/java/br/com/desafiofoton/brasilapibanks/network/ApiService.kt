package br.com.desafiofoton.brasilapibanks.network

import br.com.desafiofoton.brasilapibanks.model.Bank
import br.com.desafiofoton.brasilapibanks.model.ListResults
import br.com.desafiofoton.brasilapibanks.repository.ApiConstants.END_POINT
import br.com.desafiofoton.brasilapibanks.repository.ApiConstants.FILTER_POINT
import br.com.desafiofoton.brasilapibanks.repository.ApiConstants.PATH_CNPJ_SEQ
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET(END_POINT)
    fun getDataApi(): Call<ListResults>

    @GET("$FILTER_POINT'$PATH_CNPJ_SEQ'")
    fun getCnpjBySeq(
        @Path(PATH_CNPJ_SEQ) cnpjSequencial: Int
    ): Call<Bank>
}