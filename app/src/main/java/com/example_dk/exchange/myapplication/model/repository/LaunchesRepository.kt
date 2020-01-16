package com.example_dk.exchange.myapplication.model.repository

import com.example_dk.exchange.myapplication.entity.core.Launch
import com.example_dk.exchange.myapplication.model.data.ApiService
import com.example_dk.exchange.myapplication.model.data.storage.AppDatabase

class LaunchesRepository(
    private val apiService: ApiService,
    private val database: AppDatabase
) : BaseRepository() {

    suspend fun searchLaunches() = apiCall {
        apiService.searchLaunches()
    }

    suspend fun insertLaunch(launches: List<Launch>){
        database.launchDao().insertLaunches(launches)
    }

}