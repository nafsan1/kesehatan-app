package com.example.core.network

import com.example.core.data.RequestLogin
import com.example.core.data.ResponseLogin
import com.example.core.util.Constants.URL_LOGIN
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiServiceNotAuth {

    @POST(URL_LOGIN)
    suspend fun getLoginEmail(
        @Body login: RequestLogin
    ): Response<ResponseLogin>
}