package com.example.core.network

import android.content.Context
import com.example.core.data.RequestLogin
import com.example.core.data.ResponseLogin
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Suppress("UNCHECKED_CAST")
@Singleton
class RemoteDataSource @Inject constructor(
    private val apiServiceNotAuth: ApiServiceNotAuth,
    @ApplicationContext private val context: Context
) {
    suspend fun getLogin(login: RequestLogin): Flow<ApiResponse<Response<ResponseLogin>>> {
        return flow {
            try {
                val response = apiServiceNotAuth.getLoginEmail(login = login)
                emit(ApiResponse.Success(response))

            } catch (e: Exception) {
                emit(ApiResponse.Error(e.message.toString()))

            }
        }.flowOn(Dispatchers.IO)
    }
}