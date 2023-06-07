package com.example.weathertestapp.presentation.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

open class BaseViewModel : ViewModel() {

    fun <T> makeRequest(
        call: suspend CoroutineScope.() -> T,
        resultBlock: ((T) -> Unit)?
    ) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO, call)
            resultBlock?.invoke(result)
        }
    }
}