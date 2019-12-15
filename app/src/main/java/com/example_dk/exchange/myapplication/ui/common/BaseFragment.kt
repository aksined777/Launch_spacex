package com.example_dk.exchange.myapplication.ui.common

import android.os.Bundle
import android.view.*
import com.arellomobile.mvp.MvpAppCompatFragment
import com.example_dk.exchange.myapplication.extention.showMsg
import com.example_dk.exchange.myapplication.presentation.view.ErrorView
import com.example_dk.exchange.myapplication.presentation.view.ProgressView

abstract class BaseFragment : MvpAppCompatFragment(),
    ErrorView,
    ProgressView {

    abstract val layoutResId: Int?
    open var menuResId: Int? = null

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menuResId?.let {
            inflater.inflate(it, menu)
            super.onCreateOptionsMenu(menu, inflater)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return layoutResId?.let { inflater.inflate(it, container, false) }
    }

    override fun onShowError(error: String) {
        activity?.showMsg(error)
    }

    override fun onShowError(resId: Int) {
        activity?.showMsg(getString(resId))
    }

    override fun onShowProgress(show: Boolean) {
       // activity?.showProgress(show)
    }

    override fun onStop() {
     //   activity?.hideKeyboard()
        super.onStop()
    }

    override fun onStart() {
    //    activity?.showProgress(false) //onFirstViewAttach call in presenter after start
        super.onStart()
    }
}