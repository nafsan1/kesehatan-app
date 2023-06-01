package com.example.core.network

import com.example.core.data.ResponseError


sealed class ApiResponse<out R> {
    data class Success<out T>(val data: T) : ApiResponse<T>()
    data class Error(val errorMessage: String) : ApiResponse<Nothing>()
    data class ErrorServer(val errorResponse: ResponseError) : ApiResponse<Nothing>()
    object Empty : ApiResponse<Nothing>()
}