package com.example.weathertestapp.domain.repository

import com.example.weathertestapp.domain.model.ForecastWeather

interface WeatherRepository {
    suspend fun getForecast(city: String): List<ForecastWeather>

    suspend fun getCurrentForecast(city:String):ForecastWeather
}