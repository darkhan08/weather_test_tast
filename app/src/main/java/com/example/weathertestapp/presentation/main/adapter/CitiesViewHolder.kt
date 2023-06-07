package com.example.weathertestapp.presentation.main.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.weathertestapp.databinding.ItemCityBinding

class CitiesViewHolder(
    private val binding: ItemCityBinding,
    private val itemOnClickListener: ((String) -> Unit)? = null
) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: String) {
        binding.tvTitle.text = item
        binding.root.setOnClickListener {
            itemOnClickListener?.invoke(item)
        }
    }
}