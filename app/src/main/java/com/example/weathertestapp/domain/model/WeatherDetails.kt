package com.example.weathertestapp.domain.model

data class WeatherDetails(
    val description: String,
    val icon: String,
    val id: Long,
    val main: String
)
