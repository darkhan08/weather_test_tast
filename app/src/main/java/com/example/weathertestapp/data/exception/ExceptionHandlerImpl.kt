package com.example.weathertestapp.data.exception

import retrofit2.HttpException
import retrofit2.Response

class ExceptionHandlerImpl : ExceptionHandler {

    override fun handleException(throwable: Throwable): Throwable {
        return throwable
    }

    override suspend fun <T> handleResult(response: Response<T>): T? {
        return if (response.isSuccessful) response.body()
        else throw HttpException(response)
    }

    override fun throwEmptyBody(): Nothing = throw Exception("empty response body")
}