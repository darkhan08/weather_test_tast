package com.example.weathertestapp.data.model.response

import com.google.gson.annotations.SerializedName

data class SysDto(
    @SerializedName("pod")
    val pod: String
)