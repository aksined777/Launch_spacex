package com.example_dk.exchange.myapplication.entity.dto

import com.squareup.moshi.Json

data class RocketDTO(
    @field:Json(name = "rocket_name")
    var rocketName: String?,

    @field:Json(name = "rocket_type")
    var rocketType: String?
)

