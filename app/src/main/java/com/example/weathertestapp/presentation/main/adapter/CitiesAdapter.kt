package com.example.weathertestapp.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.weathertestapp.databinding.ItemCityBinding

class CitiesAdapter(
    private val itemOnClickListener:((String)->Unit)?=null
):ListAdapter<String, CitiesViewHolder>(CitiesDiffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitiesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCityBinding.inflate(layoutInflater,parent, false)
        return CitiesViewHolder(binding, itemOnClickListener)
    }

    override fun onBindViewHolder(holder: CitiesViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}