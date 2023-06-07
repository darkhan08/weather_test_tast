package com.example.weathertestapp.data.model.response

import com.google.gson.annotations.SerializedName

data class CloudsDto(
    @SerializedName("all")
    val all: Int
)