package com.example.weathertestapp.di

import com.example.weathertestapp.data.exception.ExceptionHandler
import com.example.weathertestapp.data.exception.ExceptionHandlerImpl
import org.koin.dsl.module

val appModule = module {
    single<ExceptionHandler> { ExceptionHandlerImpl() }
}

