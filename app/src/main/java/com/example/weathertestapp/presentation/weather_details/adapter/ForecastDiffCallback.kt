package com.example.weathertestapp.presentation.weather_details.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.weathertestapp.presentation.weather_details.model.Forecast

object ForecastDiffCallback : DiffUtil.ItemCallback<Forecast>() {
    override fun areItemsTheSame(oldItem: Forecast, newItem: Forecast): Boolean {
        return oldItem.data == newItem.data
    }

    override fun areContentsTheSame(oldItem: Forecast, newItem: Forecast): Boolean {
        return oldItem == newItem
    }
}