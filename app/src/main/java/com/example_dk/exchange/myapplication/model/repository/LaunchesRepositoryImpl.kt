package com.example_dk.exchange.myapplication.model.repository

import com.example_dk.exchange.myapplication.entity.core.Launch
import com.example_dk.exchange.myapplication.entity.dto.LaunchDTO
import com.example_dk.exchange.myapplication.model.data.ApiService
import com.example_dk.exchange.myapplication.model.data.storage.AppDatabase
import com.example_dk.exchange.myapplication.model.interfaces.LaunchesRepository


class LaunchesRepositoryImpl(
    private val apiService: ApiService,
    private val database: AppDatabase
) : BaseRepository(), LaunchesRepository {

    override suspend fun searchLaunches(): List<LaunchDTO>? = apiCall {
        apiService.searchLaunches()
    }

    override suspend fun insertLaunch(launches: List<Launch>) {
        database.launchDao().insertLaunches(launches)
    }

}