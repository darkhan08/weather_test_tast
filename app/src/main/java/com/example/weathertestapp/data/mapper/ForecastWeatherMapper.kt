package com.example.weathertestapp.data.mapper

import com.example.weathertestapp.data.model.response.ForecastDto
import com.example.weathertestapp.domain.model.ForecastWeather

class ForecastWeatherMapper : DataToDomainMapper<ForecastDto, ForecastWeather> {
    private val weatherMapper = WeatherDetailsMapper()
    private val forecastMapper = ForecastMapper()
    override fun map(model: ForecastDto): ForecastWeather {
        return ForecastWeather(
            weatherDetails = model.weatherDetailsDto.map { weatherDetailsDto ->
                weatherMapper.map(
                    weatherDetailsDto
                )
            },
            forecast = forecastMapper.map(model.forecastMainDto),
            data = model.dt_txt.orEmpty()
        )
    }
}