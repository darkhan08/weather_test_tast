package com.example.weathertestapp.di

import com.example.weathertestapp.data.service.CountryService
import com.example.weathertestapp.data.service.WeatherService
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val BASE_URL_COUNTRY = "https://countriesnow.space/api/v0.1/countries/"
private const val BASE_URL_WEATHER = "https://api.openweathermap.org/data/2.5/"
const val APPID = "30f292a0a97c1208b494d28814954046"

val networkModule = module {
    single { provideOkHttpClient() }
    single(named("countriesNowRetrofit")) { provideRetrofit(get(), BASE_URL_COUNTRY) }
    single(named("weatherRetrofit")) { provideRetrofit(get(), BASE_URL_WEATHER) }
    single { provideCountryService(get(named("countriesNowRetrofit"))) }
    single { provideWeatherService(get(named("weatherRetrofit"))) }
}


fun provideOkHttpClient(): OkHttpClient {
    val okHttpClient = OkHttpClient.Builder()
        .also { clinet ->
            if (BuildConfig.DEBUG) {
                val logging = HttpLoggingInterceptor()
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                clinet.addInterceptor(logging)
            }
        }
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .build()
    return okHttpClient
}

fun provideRetrofit(client: OkHttpClient, baseUrl: String): Retrofit {
    val gson = GsonBuilder()
        .setLenient()
        .create()
    return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create(gson))
        .client(client).build()
}

fun provideCountryService(retrofit: Retrofit): CountryService {
    return retrofit.create(CountryService::class.java)
}

fun provideWeatherService(retrofit: Retrofit): WeatherService {
    return retrofit.create(WeatherService::class.java)
}


