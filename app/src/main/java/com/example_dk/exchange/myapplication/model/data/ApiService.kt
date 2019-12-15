package com.example_dk.exchange.myapplication.model.data

import com.example_dk.exchange.myapplication.entity.dto.LaunchDTO
import retrofit2.Response
import retrofit2.http.GET



interface ApiService {
//    @GET("/api/v1/register")
//    fun register(@QueryMap params: Map<String, String>): Single<String>

    @GET("v2/launches")
    suspend fun searchLaunches(): Response<List<LaunchDTO>>

}


// https://api.spacexdata.com/v2/launches