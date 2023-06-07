package com.example.weathertestapp.data.repository

import com.example.weathertestapp.data.exception.ExceptionHandler
import com.example.weathertestapp.data.model.request.CitiesBody
import com.example.weathertestapp.data.service.CountryService
import com.example.weathertestapp.di.provideCountryService
import com.example.weathertestapp.di.provideOkHttpClient
import com.example.weathertestapp.di.provideRetrofit
import com.example.weathertestapp.domain.repository.CitiesRepository

class CitiesRepositoryImpl(
    private val countryService: CountryService,
    private val handler: ExceptionHandler
) : CitiesRepository {

    override suspend fun getCitiesOfCountry(country: String): List<String> {
        return try {
            val response = countryService.getCitiesByCountry(CitiesBody(country = country))
            handler.handleResult(response)?.data?:handler.throwEmptyBody()
        }catch (e: Exception){
           throw handler.handleException(e)
        }
    }
}