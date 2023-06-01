package com.example.core.repository

import com.example.core.data.RequestLogin
import com.example.core.data.ResponseError
import com.example.core.data.ResponseLogin
import com.example.core.network.ApiResponse
import com.example.core.network.RemoteDataSource
import com.example.core.network.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val pref: PreferencesRepository
) : MyRepository {
    override fun getLogin(login: RequestLogin): Flow<Resource<ResponseLogin>> {
        return flow {
            try {
                emit(Resource.Loading(isLoading = true))
                when (val apiResponse = remoteDataSource.getLogin(login).first()) {
                    is ApiResponse.Success -> {
                        val response = apiResponse.data
                        val data = response.body()

                        if (data != null) {
                            pref.setIsLogin(true)
                            pref.setToken(data.token)
                            emit(Resource.Success(data))
                        } else {
                            emit(
                                Resource.ErrorFromServer(
                                    errorResponse = ResponseError(
                                        code = response.code(),
                                        error = response.message()
                                    ),
                                    data = null
                                )
                            )
                        }
                        emit(Resource.Loading(null, isLoading = false))
                    }
                    is ApiResponse.Error -> {
                        emit(Resource.Loading(isLoading = false))
                        emit(
                            Resource.Error(
                                apiResponse.errorMessage, null
                            )
                        )
                    }
                    else -> {
                        emit(Resource.Loading(isLoading = false))
                        emit(Resource.Error("Something wen wrong", null))
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Loading(isLoading = false))
                emit(Resource.Error(e.message.toString(), null))
            }
        }
    }
}