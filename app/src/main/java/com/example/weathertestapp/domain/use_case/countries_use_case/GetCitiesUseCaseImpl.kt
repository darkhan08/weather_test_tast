package com.example.weathertestapp.domain.use_case.countries_use_case

import com.example.weathertestapp.domain.repository.CitiesRepository

class GetCitiesUseCaseImpl(
    private val citiesRepository: CitiesRepository
    ):GetCitiesUseCase {
    override suspend fun getCities(country:String): List<String> {
        return citiesRepository.getCitiesOfCountry(country)
    }
}