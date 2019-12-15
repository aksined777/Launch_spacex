package com.example_dk.exchange.myapplication.entity.dto

import com.squareup.moshi.Json

data class Data(
    @Json(name = "en")
    val en: String,
    @Json(name = "hint")
    val hint: List<Any>
)