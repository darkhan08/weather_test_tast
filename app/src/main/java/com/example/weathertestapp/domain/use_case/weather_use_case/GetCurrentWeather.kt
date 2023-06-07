package com.example.weathertestapp.domain.use_case.weather_use_case

import com.example.weathertestapp.domain.model.ForecastWeather

interface GetCurrentWeather {
    suspend fun invoke(city: String): ForecastWeather
}