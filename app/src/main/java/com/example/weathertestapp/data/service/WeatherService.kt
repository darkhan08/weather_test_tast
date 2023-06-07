package com.example.weathertestapp.data.service

import com.example.weathertestapp.data.model.response.ForecastDto
import com.example.weathertestapp.data.model.response.WeatherDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("forecast")
    suspend fun getForecast(
        @Query("q") city: String,
        @Query("appid") userId: String,
        @Query("lang") language: String = "ru",
        @Query("units") units: String = "metric"
    ): Response<WeatherDto>

    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") city: String,
        @Query("appid") userId: String,
        @Query("lang") language: String = "ru",
        @Query("units") units: String = "metric"
    ): Response<ForecastDto>
}