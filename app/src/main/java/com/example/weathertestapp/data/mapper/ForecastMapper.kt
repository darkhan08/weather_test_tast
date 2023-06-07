package com.example.weathertestapp.data.mapper

import com.example.weathertestapp.data.model.response.ForecastMainDto
import com.example.weathertestapp.domain.model.Forecast

class ForecastMapper : DataToDomainMapper<ForecastMainDto, Forecast> {
    override fun map(model: ForecastMainDto): Forecast {
        return Forecast(
            feels_like = model.feels_like,
            grnd_level = model.grnd_level,
            humidity = model.humidity,
            pressure = model.pressure,
            sea_level = model.sea_level,
            temp = model.temp,
            temp_kf = model.temp_kf,
            temp_max = model.temp_max,
            temp_min = model.temp_min
        )
    }
}