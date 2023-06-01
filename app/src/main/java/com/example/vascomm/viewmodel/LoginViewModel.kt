package com.example.vascomm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.data.RequestLogin
import com.example.core.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: MyRepository
) : ViewModel() {

    fun getLogin(login: RequestLogin) = repository.getLogin(login = login).asLiveData()
}