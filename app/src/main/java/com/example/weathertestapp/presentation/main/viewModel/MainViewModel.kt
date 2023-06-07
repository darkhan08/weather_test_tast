package com.example.weathertestapp.presentation.main.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weathertestapp.domain.use_case.countries_use_case.GetCitiesUseCase
import com.example.weathertestapp.presentation.utils.BaseViewModel
import com.example.weathertestapp.presentation.utils.COUNTRY_KAZ

class MainViewModel(private val citiesUseCase: GetCitiesUseCase) : BaseViewModel() {
    private val _citiesLiveData = MutableLiveData<List<String>>()
    val citiesLiveData: LiveData<List<String>> get() = _citiesLiveData

    private val _loaderLiveData = MutableLiveData<Boolean>(false)
    val loaderLiveData: LiveData<Boolean> get() = _loaderLiveData

    fun getCitiesByCountry() {
        _loaderLiveData.value = true
        makeRequest({ citiesUseCase.getCities(COUNTRY_KAZ) }) {
            _citiesLiveData.value = it
            _loaderLiveData.value = false
        }
    }
}