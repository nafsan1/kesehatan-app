package com.example.core.repository

import com.example.core.data.RequestLogin
import com.example.core.data.ResponseLogin
import com.example.core.network.Resource
import kotlinx.coroutines.flow.Flow

interface MyRepository {
    fun getLogin(login: RequestLogin): Flow<Resource<ResponseLogin>>

}