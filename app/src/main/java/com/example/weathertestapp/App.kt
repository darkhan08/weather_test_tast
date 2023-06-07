package com.example.weathertestapp

import android.app.Application
import com.example.weathertestapp.di.appModule
import com.example.weathertestapp.di.networkModule
import com.example.weathertestapp.di.repositoryModule
import com.example.weathertestapp.di.useCaseModule
import com.example.weathertestapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule,
                    appModule
                )
            )
        }
    }
}