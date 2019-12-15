package com.example_dk.exchange.myapplication.presentation.presenter

import com.arellomobile.mvp.InjectViewState
import com.example_dk.exchange.myapplication.entity.core.Launch
import com.example_dk.exchange.myapplication.model.interactor.LaunchesInteractor
import com.example_dk.exchange.myapplication.presentation.view.LaunchesView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject
import kotlin.collections.toList as toList1

@InjectViewState
class LaunchesPresenter : BasePresenter<LaunchesView>(), KoinComponent {

    private val launchesInteractor: LaunchesInteractor by inject()

    private var launches: List<Launch>? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getLaunchesFromServer()
    }

    private fun getLaunchesFromServer() {
        viewState.onShowProgress(true)
        coroutineScope.launch {
            try {
                launches = launchesInteractor.searchLaunches()
                withContext(Dispatchers.Main) {
                    viewState.onShowProgress(false)
                    launches?.let {
                        viewState.onShowLaunches(it)
                    }
                }
            } catch (e: Throwable) {
                withContext(Dispatchers.Main) {
                    viewState.onShowProgress(false)
                    handleError(e)
                }
            }
        }
    }

    fun getLaunches() {
        launches?.let { viewState.onShowLaunches(it) }
    }
}