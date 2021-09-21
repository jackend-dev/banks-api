package br.com.desafiofoton.brasilapibanks.repository

object ApiConstants {

    const val BASE_URL =
        "https://olinda.bcb.gov.br/olinda/servico/Informes_Agencias/versao/v1/odata/"
    const val END_POINT = "Agencias?\$top=20"
    const val FILTER_POINT = "$END_POINT&\$filter=CnpjSequencial%20eq%20"
    const val PATH_CNPJ_SEQ = "CnpjSequencial"


}