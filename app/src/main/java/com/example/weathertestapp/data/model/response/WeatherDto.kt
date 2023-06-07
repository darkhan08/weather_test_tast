package com.example.weathertestapp.data.model.response

import com.google.gson.annotations.SerializedName

data class WeatherDto(
    @SerializedName("cnt")
    val cnt: Int,
    @SerializedName("cod")
    val cod: String,
    @SerializedName("list")
    val list: List<ForecastDto>,
    @SerializedName("message")
    val message: Int
)