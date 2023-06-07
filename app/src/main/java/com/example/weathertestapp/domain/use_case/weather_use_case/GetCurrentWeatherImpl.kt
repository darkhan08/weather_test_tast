package com.example.weathertestapp.domain.use_case.weather_use_case

import com.example.weathertestapp.domain.model.ForecastWeather
import com.example.weathertestapp.domain.repository.WeatherRepository

class GetCurrentWeatherImpl(private val repository: WeatherRepository) : GetCurrentWeather {
    override suspend fun invoke(city: String): ForecastWeather {
        return repository.getCurrentForecast(city)
    }
}