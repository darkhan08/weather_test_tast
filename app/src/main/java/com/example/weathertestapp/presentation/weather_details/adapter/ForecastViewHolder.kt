package com.example.weathertestapp.presentation.weather_details.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weathertestapp.databinding.ItemWeatherBinding
import com.example.weathertestapp.presentation.weather_details.model.Forecast

class ForecastViewHolder(private val binding: ItemWeatherBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: Forecast) = with(binding) {
        tvData.text = item.data
        tvMaxTemp.text = "${item.maxTemp} °C"
        tvMinTemp.text = "${item.minTemp} °C"
        tvTemp.text = "${item.temp} °C"

        println(item.icon)
        Glide.with(root)
            .load(item.icon)
            .into(ivIcon)
    }
}