package com.example.weathertestapp.data.exception

import retrofit2.Response

interface ExceptionHandler {
    fun handleException(throwable: Throwable): Throwable

    suspend fun <T> handleResult(response: Response<T>):T?

    fun throwEmptyBody(): Nothing
}