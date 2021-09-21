package br.com.desafiofoton.brasilapibanks.util

import android.app.Activity
import android.widget.Toast

object Extensions {

    // setar o toast com a mensagem
    fun Activity.toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}