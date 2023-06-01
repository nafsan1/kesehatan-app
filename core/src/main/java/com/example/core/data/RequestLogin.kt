package com.example.core.data

import com.google.gson.annotations.SerializedName

data class RequestLogin(
    @field:SerializedName("email")
    val email:String = "",
    @field:SerializedName("password")
    val password:String = ""
)
