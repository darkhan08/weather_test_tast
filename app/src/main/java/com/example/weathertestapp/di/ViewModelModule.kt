package com.example.weathertestapp.di

import com.example.weathertestapp.presentation.main.viewModel.MainViewModel
import com.example.weathertestapp.presentation.weather_details.WeatherDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { WeatherDetailsViewModel(get(), get()) }
}