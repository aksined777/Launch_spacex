package com.example_dk.exchange.myapplication.model.repository


import com.example_dk.exchange.myapplication.entity.dto.ServerErrorDTO
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import org.koin.core.KoinComponent

open class BaseRepository : KoinComponent {

    private val serverErrorAdapter: JsonAdapter<ServerErrorDTO> by lazy {
        Moshi.Builder().build().adapter(ServerErrorDTO::class.java)
    }

    suspend fun <T : Any> apiCall(call: suspend () -> retrofit2.Response<List<T>>): List<T>? {
        try {
            val response = call.invoke()
            val body = response.body()

            val stringError = response.errorBody()?.string()

            val errorBody = try {
                stringError?.let {
                    serverErrorAdapter.fromJson(it)
                }
            } catch (e: Throwable) {
                null
            }

            when {
                response.code() in 500..505 -> throw ServerError()
                errorBody is ServerErrorDTO -> throw ServerError(errorBody.message)
            }

            return body

        } catch (e: Throwable) {
            throw e
        }
    }
}


class ServerError(val serverMessage: String? = null) :
    RuntimeException()