package com.example.weathertestapp.presentation.weather_details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.weathertestapp.databinding.ItemWeatherBinding
import com.example.weathertestapp.presentation.weather_details.model.Forecast

class ForecastAdapter: ListAdapter<Forecast,ForecastViewHolder>(ForecastDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemWeatherBinding.inflate(layoutInflater, parent, false)
        return ForecastViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}