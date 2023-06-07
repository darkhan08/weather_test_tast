package com.example.weathertestapp.presentation.weather_details.model

data class Forecast(
    val minTemp: Double,
    val maxTemp: Double,
    val temp: Double,
    val weather: String,
    val icon: String,
    val data: String
)