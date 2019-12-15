package com.example_dk.exchange.myapplication.presentation.view

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example_dk.exchange.myapplication.entity.core.Launch

interface LaunchesView : BaseView, ProgressView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun onShowLaunches(launches: List<Launch>)

}