package com.example.weathertestapp.data.model.response

import com.google.gson.annotations.SerializedName

data class WeatherDetailsDto(
    @SerializedName("description")
    val description: String,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("id")
    val id: Long,
    @SerializedName("main")
    val main: String
)