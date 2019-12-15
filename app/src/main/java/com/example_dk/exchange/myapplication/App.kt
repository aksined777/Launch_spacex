package com.example_dk.exchange.myapplication

import android.app.Application
import com.example_dk.exchange.myapplication.di.appModule
import com.example_dk.exchange.myapplication.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    appModule, networkModule
                )
            )
        }
    }
}