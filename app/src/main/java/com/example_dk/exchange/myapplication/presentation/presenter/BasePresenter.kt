package com.example_dk.exchange.myapplication.presentation.presenter

import com.arellomobile.mvp.MvpPresenter
import com.example_dk.exchange.myapplication.R
import com.example_dk.exchange.myapplication.model.repository.ServerError
import com.example_dk.exchange.myapplication.presentation.view.BaseView
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

abstract class BasePresenter<View : BaseView> : MvpPresenter<View>() {

    private val exHandler = CoroutineExceptionHandler { _, exception ->
        handleError(exception)
    }
    private val job = SupervisorJob()
    private val coroutineContext: CoroutineContext = Dispatchers.IO + exHandler + job
    val coroutineScope = CoroutineScope(coroutineContext)

    override fun onDestroy() {
        coroutineContext.cancel()
        super.onDestroy()
    }

    fun handleError(error: Throwable) {
        when (error) {
            is ServerError -> {
                error.serverMessage?.let {
                    viewState.onShowError(it)
                } ?: run {
                    viewState.onShowError(R.string.server_error)
                }
            }
            else -> {
                viewState.onShowError(R.string.app_error)
            }
        }
    }

}