package com.example.weathertestapp.presentation.weather_details.mapper

import com.example.weathertestapp.data.mapper.DataToDomainMapper
import com.example.weathertestapp.di.APPID
import com.example.weathertestapp.domain.model.ForecastWeather
import com.example.weathertestapp.presentation.weather_details.model.Forecast

class ForecastMapper : DataToDomainMapper<ForecastWeather, Forecast> {
    override fun map(model: ForecastWeather): Forecast {
        return Forecast(
            minTemp = model.forecast.temp_min,
            maxTemp = model.forecast.temp_max,
            temp = model.forecast.temp,
            weather = model.weatherDetails[0].description,
            icon = "https://openweathermap.org/img/w/${model.weatherDetails[0].icon}.png?appid=$APPID",
            data = model.data
        )
    }
}