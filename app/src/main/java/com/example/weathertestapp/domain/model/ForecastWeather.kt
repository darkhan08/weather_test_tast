package com.example.weathertestapp.domain.model

data class ForecastWeather(
    val weatherDetails: List<WeatherDetails>,
    val forecast: Forecast,
    val data: String
)