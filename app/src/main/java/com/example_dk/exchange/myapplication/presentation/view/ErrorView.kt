package com.example_dk.exchange.myapplication.presentation.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface ErrorView : MvpView {
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun onShowError(error : String)
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun onShowError(resId : Int)
}