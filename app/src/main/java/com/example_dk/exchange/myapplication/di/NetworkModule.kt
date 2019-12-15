package com.example_dk.exchange.myapplication.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example_dk.exchange.myapplication.BuildConfig.BASE_URL
import com.example_dk.exchange.myapplication.model.data.ApiService
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    factory { provideDefaultOkhttpClient(androidContext()) }
    single { provideChatterApiService(provideRetrofit(androidContext(), BASE_URL)) }
}

fun provideDefaultOkhttpClient(contex: Context): OkHttpClient.Builder {
    return OkHttpClient.Builder()
//        .addInterceptor { chain ->
//            val newBuilder = chain.request().newBuilder()
//            newBuilder
//                .addHeader("Content-Type", "application/json")
//                .addHeader("Accept", "application/json")
//
//            return@addInterceptor chain.proceed(newBuilder.build())
//        }
//        .addInterceptor(ChuckerInterceptor(contex))
//        .readTimeout(90, TimeUnit.SECONDS)
//        .connectTimeout(90, TimeUnit.SECONDS)
}

fun provideRetrofit(contex: Context, baseUrl: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(provideDefaultOkhttpClient(contex).build())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}

fun provideChatterApiService(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)

fun String?.getFullUrl() = if (this != null) {
    "$BASE_URL/$this"
} else ""