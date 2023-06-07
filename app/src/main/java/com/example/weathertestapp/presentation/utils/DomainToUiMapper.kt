package com.example.weathertestapp.presentation.utils

interface DomainToUiMapper<T, K> {
    fun map(model: T): K
}