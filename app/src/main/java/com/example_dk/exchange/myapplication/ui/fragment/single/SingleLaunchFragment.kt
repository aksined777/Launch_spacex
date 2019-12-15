package com.example_dk.exchange.myapplication.ui.fragment.single

import com.example_dk.exchange.myapplication.R
import com.example_dk.exchange.myapplication.ui.common.BaseFragment

class SingleLaunchFragment :  BaseFragment(){

    override val layoutResId = R.layout.single_launch_fragment

    companion object {
        public const val LAUNCH_ARG = "profile arg"
    }

}