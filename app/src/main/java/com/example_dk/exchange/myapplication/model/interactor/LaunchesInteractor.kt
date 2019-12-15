package com.example_dk.exchange.myapplication.model.interactor

import com.example_dk.exchange.myapplication.entity.core.Launch
import com.example_dk.exchange.myapplication.entity.dto.toLaunch
import com.example_dk.exchange.myapplication.model.repository.LaunchesRepository

class LaunchesInteractor(
    private var launchesRepository: LaunchesRepository
) {

    suspend fun searchLaunches(): List<Launch>? {
        val result = launchesRepository.searchLaunches()?.map { it.toLaunch() }
        result?.let{launchesRepository.insertLaunch(it)}
        return result
    }


}