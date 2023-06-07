package com.example.weathertestapp.data.model.request

import com.google.gson.annotations.SerializedName

data class CitiesBody(
    @SerializedName("country")
    val country: String
)