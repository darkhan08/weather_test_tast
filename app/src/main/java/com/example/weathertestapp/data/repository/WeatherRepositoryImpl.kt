package com.example.weathertestapp.data.repository

import com.example.weathertestapp.data.exception.ExceptionHandler
import com.example.weathertestapp.data.mapper.ForecastWeatherMapper
import com.example.weathertestapp.data.service.WeatherService
import com.example.weathertestapp.di.APPID
import com.example.weathertestapp.domain.model.ForecastWeather
import com.example.weathertestapp.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val weatherService: WeatherService,
    private val handler: ExceptionHandler
) : WeatherRepository {
    private val forecastWeatherMapper = ForecastWeatherMapper()

    override suspend fun getForecast(city: String): List<ForecastWeather> {
        return try {
            val response =
                weatherService.getForecast(city, userId = APPID)
            handler.handleResult(response)?.list?.map { forecastDto ->
                forecastWeatherMapper.map(
                    forecastDto
                )
            } ?: handler.throwEmptyBody()
        } catch (e: Exception) {
            throw handler.handleException(e)
        }
    }

    override suspend fun getCurrentForecast(city: String): ForecastWeather {
        return try {
            val response =
                weatherService.getCurrentWeather(city, userId = APPID)
            val result = handler.handleResult(response)
            forecastWeatherMapper.map(result ?: handler.throwEmptyBody())
        } catch (e: Exception) {
            throw handler.handleException(e)
        }
    }
}