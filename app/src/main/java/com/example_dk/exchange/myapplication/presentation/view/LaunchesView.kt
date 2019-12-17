package com.example_dk.exchange.myapplication.presentation.view

import android.view.MenuItem
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example_dk.exchange.myapplication.entity.core.Launch

interface LaunchesView : BaseView, ProgressView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun onShowLaunches(launches: List<Launch>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun onShowSortMenu(item: MenuItem, toSort:Boolean, launches: List<Launch>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun onDrawMenu(item: MenuItem, toSort: Boolean)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun onShowError()
}