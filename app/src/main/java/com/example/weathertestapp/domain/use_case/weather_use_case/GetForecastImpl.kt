package com.example.weathertestapp.domain.use_case.weather_use_case

import com.example.weathertestapp.domain.model.ForecastWeather
import com.example.weathertestapp.domain.repository.WeatherRepository

class GetForecastImpl(
    private val repository: WeatherRepository
) : GetForecast {
    override suspend fun invoke(city: String): List<ForecastWeather> {
        return repository.getForecast(city)
    }
}