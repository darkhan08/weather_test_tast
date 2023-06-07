package com.example.weathertestapp.di

import com.example.weathertestapp.data.repository.CitiesRepositoryImpl
import com.example.weathertestapp.data.repository.WeatherRepositoryImpl
import com.example.weathertestapp.domain.repository.CitiesRepository
import com.example.weathertestapp.domain.repository.WeatherRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<CitiesRepository> { CitiesRepositoryImpl(get(), get()) }
    single<WeatherRepository> { WeatherRepositoryImpl(get(), get()) }
}