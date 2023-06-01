package com.example.core.network

import com.example.core.data.ResponseError

sealed class Resource<out T>(
    val data: T? = null,
    val message: String? = null,
    val isLoading: Boolean? = false,
    val errorResponse: ResponseError? = null
) {
    class Success<out T>(data: T) : Resource<T>(data = data)
    class Loading<out T>(data: T? = null, isLoading: Boolean? = true) :
        Resource<T>(data = data, isLoading = isLoading)
    class Error<out T>(message: String, data: T? = null) : Resource<T>(data, message)
    class ErrorFromServer<out T>(errorResponse: ResponseError, data: T? = null) :
        Resource<T>(data,errorResponse = errorResponse)

}