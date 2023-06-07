package com.example.weathertestapp.data.model.response

import com.google.gson.annotations.SerializedName

data class CitiesDto(
    @SerializedName("error")
    val error: String?,
    @SerializedName("msg")
    val msg: String?,
    @SerializedName("data")
    val data:List<String>?
)