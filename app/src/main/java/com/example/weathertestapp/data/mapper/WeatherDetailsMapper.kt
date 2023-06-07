package com.example.weathertestapp.data.mapper

import com.example.weathertestapp.data.model.response.WeatherDetailsDto
import com.example.weathertestapp.domain.model.WeatherDetails

class WeatherDetailsMapper : DataToDomainMapper<WeatherDetailsDto, WeatherDetails> {

    override fun map(model: WeatherDetailsDto): WeatherDetails {
        return WeatherDetails(
            description = model.description,
            icon = model.icon,
            id = model.id,
            main = model.main
        )
    }
}