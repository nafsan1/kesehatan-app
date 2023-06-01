package com.example.core.data

import com.google.gson.annotations.SerializedName

data class ResponseError(
    @field:SerializedName("code")
    val code:Int = 400,
    @field:SerializedName("error")
    val error: String = ""
)