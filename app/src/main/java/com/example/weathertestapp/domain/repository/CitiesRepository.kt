package com.example.weathertestapp.domain.repository


interface CitiesRepository {
    suspend fun getCitiesOfCountry(country: String):List<String>
}