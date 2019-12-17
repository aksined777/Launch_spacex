package com.example_dk.exchange.myapplication.model.data.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example_dk.exchange.myapplication.BuildConfig
import com.example_dk.exchange.myapplication.entity.core.Launch
import com.example_dk.exchange.myapplication.model.data.storage.dao.LaunchDao


@Database(
    entities = [Launch::class],
    version = BuildConfig.VERSION_CODE,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun launchDao(): LaunchDao

    companion object {
        val DATABASE_NAME = "spacex_db"

        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase? {
            if (instance == null) {
                synchronized(AppDatabase::class) {
                    if (instance == null) {
                        instance =
                            Room.databaseBuilder(
                                context.applicationContext,
                                AppDatabase::class.java,
                                DATABASE_NAME
                            )
                                .fallbackToDestructiveMigration()
                                .build()
                    }
                }
            }
            return instance
        }
    }
}