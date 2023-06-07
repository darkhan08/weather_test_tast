package com.example.weathertestapp.data.model.response

import com.google.gson.annotations.SerializedName

data class ForecastDto(
    @SerializedName("clouds")
    val cloudsDto: CloudsDto,
    @SerializedName("dt")
    val dt: Int,
    @SerializedName("dt_txt")
    val dt_txt: String?,
    @SerializedName("main")
    val forecastMainDto: ForecastMainDto,
    @SerializedName("pop")
    val pop: Double,
    @SerializedName("sys")
    val sysDto: SysDto,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("weather")
    val weatherDetailsDto: List<WeatherDetailsDto>,
)