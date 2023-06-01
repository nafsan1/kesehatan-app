package com.example.core.data

import com.google.gson.annotations.SerializedName

data class ResponseLogin(
    @field:SerializedName("token")
    val token:String = ""
)
