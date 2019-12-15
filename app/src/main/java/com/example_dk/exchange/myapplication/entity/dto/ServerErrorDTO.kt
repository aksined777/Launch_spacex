package com.example_dk.exchange.myapplication.entity.dto

import com.squareup.moshi.Json

data class ServerErrorDTO(
    @Json(name = "data")
    val errorData : Data?,
    @Json(name = "error")
    val error: String?,
    @Json(name = "message")
    val message: String?
)