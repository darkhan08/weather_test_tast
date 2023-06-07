package com.example.weathertestapp.domain.use_case.countries_use_case

interface GetCitiesUseCase {
    suspend fun getCities(country: String):List<String>
}