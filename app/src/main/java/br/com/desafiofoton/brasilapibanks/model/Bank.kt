package br.com.desafiofoton.brasilapibanks.model

data class Bank(
    val CnpjSequencial: Int,
    val NomeIf: String,
    val NomeAgencia: String,
    val Endereco: String,
    val Complemento: String,
    val Bairro: String,
    val Municipio: String,
    val UF: String
)
