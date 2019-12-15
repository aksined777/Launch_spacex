package com.example_dk.exchange.myapplication.ui

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example_dk.exchange.myapplication.R
import com.example_dk.exchange.myapplication.entity.core.Launch
import com.example_dk.exchange.myapplication.presentation.presenter.LaunchesPresenter
import com.example_dk.exchange.myapplication.presentation.view.LaunchesView
import com.example_dk.exchange.myapplication.ui.common.BaseFragment
import com.example_dk.exchange.myapplication.ui.fragment.launches.LauncherDifferDelegateAdapter
import com.example_dk.exchange.myapplication.ui.fragment.single.SingleLaunchFragment

import kotlinx.android.synthetic.main.launches_fragment.*

class LaunchesFragment :  BaseFragment(), LaunchesView {

    override val layoutResId = R.layout.launches_fragment

    @InjectPresenter
    lateinit var presenter: LaunchesPresenter


    @ProvidePresenter
    fun providePresenter(): LaunchesPresenter = LaunchesPresenter()

    private val recyclerVAdapter: LauncherDifferDelegateAdapter by lazy {
        LauncherDifferDelegateAdapter(
            ::onItemClickListener
        )
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.setLayoutManager( LinearLayoutManager(context))
        recyclerView.adapter = recyclerVAdapter
        recyclerView.itemAnimator = null

        presenter.getLaunches()
    }

    override fun onShowLaunches(launches: List<Launch>) {
        recyclerVAdapter.items = launches.toList()
    }

    fun onItemClickListener(launch:Launch){
        findNavController().navigate(
            R.id.action_launchFragment_to_singleLaunchFragment,
            bundleOf(
                Pair(SingleLaunchFragment.LAUNCH_ARG, launch)
            )
        )
    }
}