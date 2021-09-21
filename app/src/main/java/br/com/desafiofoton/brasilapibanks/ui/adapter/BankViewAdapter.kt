package br.com.desafiofoton.brasilapibanks.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.desafiofoton.brasilapibanks.databinding.BankItemBinding
import br.com.desafiofoton.brasilapibanks.model.Bank
import br.com.desafiofoton.brasilapibanks.ui.holder.BankViewHolder

class BankViewAdapter(
    val bankClickListener: (Int) -> Unit
) : RecyclerView.Adapter<BankViewHolder>() {
    val listBank : MutableList<Bank> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = BankItemBinding.inflate(inflater, parent, false)

        return BankViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BankViewHolder, position: Int) {
       val item = listBank[position]

        holder.let {
            it.binding.tvName.text = item.NomeIf
            it.binding.tvFullName.text = item.UF
            it.binding.tvName.setOnClickListener {
                bankClickListener(item.CnpjSequencial)
            }
        }
    }

    override fun getItemCount() = listBank.size

    fun addItems(item: List<Bank>) {
        listBank.addAll(item)
        notifyDataSetChanged()
    }



}