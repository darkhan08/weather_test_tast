package com.example.weathertestapp.data.service

import com.example.weathertestapp.data.model.request.CitiesBody
import com.example.weathertestapp.data.model.response.CitiesDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface CountryService {

    @POST("cities")
    suspend fun getCitiesByCountry(@Body citiesBody: CitiesBody): Response<CitiesDto>
}