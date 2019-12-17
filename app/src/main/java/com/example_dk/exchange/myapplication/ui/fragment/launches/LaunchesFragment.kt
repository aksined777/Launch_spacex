package com.example_dk.exchange.myapplication.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example_dk.exchange.myapplication.R
import com.example_dk.exchange.myapplication.entity.core.Launch
import com.example_dk.exchange.myapplication.utlils.extention.swipeEnabled
import com.example_dk.exchange.myapplication.presentation.presenter.LaunchesPresenter
import com.example_dk.exchange.myapplication.presentation.view.LaunchesView
import com.example_dk.exchange.myapplication.ui.common.BaseFragment
import com.example_dk.exchange.myapplication.ui.fragment.launches.LauncherDifferDelegateAdapter
import com.example_dk.exchange.myapplication.ui.fragment.single.SingleLaunchFragment
import kotlinx.android.synthetic.main.include_error.*
import kotlinx.android.synthetic.main.launches_fragment.*


class LaunchesFragment : BaseFragment(), LaunchesView {

    override val layoutResId = R.layout.launches_fragment
    override var menuResId: Int? = R.menu.main

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

        recyclerView.setLayoutManager(LinearLayoutManager(context))
        recyclerView.adapter = recyclerVAdapter
        recyclerView.itemAnimator = null

        presenter.getLaunches()
    }

    override fun onShowLaunches(launches: List<Launch>) {
        recyclerVAdapter.items = launches.toList()
        activity?.swipeEnabled(false)
    }



    fun onItemClickListener(launch: Launch) {
        findNavController().navigate(
            R.id.action_launchFragment_to_singleLaunchFragment,
            bundleOf(
                Pair(SingleLaunchFragment.LAUNCH_ARG, launch)
            )
        )
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_updown -> {
                presenter.doSort(item)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDrawMenu(item: MenuItem, toSort: Boolean){
        if (toSort) {
            item.setIcon(R.drawable.ic_arrow_downward)
        } else {
            item.setIcon(R.drawable.ic_arrow_up)
        }
    }

    override fun onShowError() {
        errorView.visibility = View.VISIBLE
    }

    override fun onShowSortMenu(item: MenuItem, toSort: Boolean, launches: List<Launch>) {
        onDrawMenu(item, toSort)
        recyclerVAdapter.items = launches.toList()
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        presenter.onPrepareOptionsMenu(menu.findItem(R.id.action_updown))
    }

}