package com.example_dk.exchange.myapplication.model.interfaces

import com.example_dk.exchange.myapplication.entity.core.Launch
import com.example_dk.exchange.myapplication.entity.dto.LaunchDTO

interface LaunchesRepository {
    suspend fun searchLaunches(): List<LaunchDTO>?

    suspend fun insertLaunch(launches: List<Launch>)
}