package com.example.weathertestapp.di

import com.example.weathertestapp.domain.use_case.countries_use_case.GetCitiesUseCase
import com.example.weathertestapp.domain.use_case.countries_use_case.GetCitiesUseCaseImpl
import com.example.weathertestapp.domain.use_case.weather_use_case.GetCurrentWeather
import com.example.weathertestapp.domain.use_case.weather_use_case.GetCurrentWeatherImpl
import com.example.weathertestapp.domain.use_case.weather_use_case.GetForecast
import com.example.weathertestapp.domain.use_case.weather_use_case.GetForecastImpl
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetCitiesUseCase> { GetCitiesUseCaseImpl(get()) }
    factory<GetForecast> { GetForecastImpl(get()) }
    factory<GetCurrentWeather> { GetCurrentWeatherImpl(get()) }
}