package com.example.weathertestapp.data.mapper

interface DataToDomainMapper<T, K> {
    fun map(model: T): K
}