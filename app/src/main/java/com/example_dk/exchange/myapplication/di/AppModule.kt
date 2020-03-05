package com.example_dk.exchange.myapplication.di

import com.example_dk.exchange.myapplication.model.data.storage.AppDatabase
import com.example_dk.exchange.myapplication.model.interactor.LaunchesInteractor
import com.example_dk.exchange.myapplication.model.repository.LaunchesRepositoryImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {
    single {
        AppDatabase.getDatabase(androidApplication())
    }
    factory {
        LaunchesRepositoryImpl(get(), get())
    }

    factory {
        LaunchesInteractor(get() as LaunchesRepositoryImpl )
    }
}