package com.example_dk.exchange.myapplication.di


import com.example_dk.exchange.myapplication.BuildConfig.BASE_URL
import com.example_dk.exchange.myapplication.model.data.ApiService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


val networkModule = module {
    factory { provideDefaultOkhttpClient() }
    single { provideChatterApiService(provideRetrofit(BASE_URL)) }
}

fun provideDefaultOkhttpClient(): OkHttpClient.Builder {
    return OkHttpClient.Builder()
}

fun provideRetrofit(baseUrl: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(provideDefaultOkhttpClient().build())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}

fun provideChatterApiService(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)

