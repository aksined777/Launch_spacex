package com.example_dk.exchange.myapplication.model.data.storage.dao

import androidx.room.*
import com.example_dk.exchange.myapplication.entity.core.Launch

@Dao
interface LaunchDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLaunches(launches: List<Launch>)

    @Query("SELECT * FROM Launch where id = :id")
    suspend fun getLaunch(id: Int): Launch
}