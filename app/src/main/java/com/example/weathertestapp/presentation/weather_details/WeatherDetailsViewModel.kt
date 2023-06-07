package com.example.weathertestapp.presentation.weather_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weathertestapp.domain.use_case.weather_use_case.GetCurrentWeather
import com.example.weathertestapp.domain.use_case.weather_use_case.GetForecast
import com.example.weathertestapp.presentation.utils.BaseViewModel
import com.example.weathertestapp.presentation.weather_details.mapper.ForecastMapper
import com.example.weathertestapp.presentation.weather_details.model.Forecast

class WeatherDetailsViewModel(
    private val getForecast: GetForecast,
    private val getCurrentWeather: GetCurrentWeather
) : BaseViewModel() {
    private val forecastMapper = ForecastMapper()
    private val _forecastLiveData = MutableLiveData<List<Forecast>>()
    private val _loaderLiveData = MutableLiveData<Boolean>(false)
    private val _currentWeatherLiveData = MutableLiveData<Forecast>()


    val loaderLiveData: LiveData<Boolean> get() = _loaderLiveData
    val forecastLiveData: LiveData<List<Forecast>> get() = _forecastLiveData
    val currentWeatherLiveData: LiveData<Forecast> get() = _currentWeatherLiveData

    fun getForecast(city: String) {
        _loaderLiveData.value = true
        makeRequest({ getForecast.invoke(city) }) {
            _forecastLiveData.value =
                it.map { forecastWeather -> forecastMapper.map(forecastWeather) }
            _loaderLiveData.value = false
        }
    }

    fun getCurrentWeather(city: String) {
        _loaderLiveData.value = true
        makeRequest({ getCurrentWeather.invoke(city) }) {
            _currentWeatherLiveData.value = forecastMapper.map(it)
            _loaderLiveData.value = false
        }
    }
}