package com.example_dk.exchange.myapplication.ui.fragment.single

import android.os.Build
import android.os.Bundle
import android.view.View
import com.example_dk.exchange.myapplication.R
import com.example_dk.exchange.myapplication.entity.core.Launch
import com.example_dk.exchange.myapplication.ui.common.BaseFragment
import com.example_dk.exchange.myapplication.utlils.argument
import com.example_dk.exchange.myapplication.utlils.extention.load
import com.example_dk.exchange.myapplication.utlils.extention.onClickUrl
import kotlinx.android.synthetic.main.include_desc.*
import kotlinx.android.synthetic.main.single_launch_fragment.*


class SingleLaunchFragment :  BaseFragment(){

    override val layoutResId = R.layout.single_launch_fragment

    companion object {
        const val LAUNCH_ARG = "profile arg"
    }

    private val launch: Launch by argument(LAUNCH_ARG)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ivLogo.load(launch.urlLogo)
        tvMissionName.text = launch.missionName
        tvRockerName.text = launch.rocketName
        tvRocketType.text = launch.rocketType
        tvDate.text = launch.date
        launchPlace.text = launch.siteNameLong
        tvDetails.text = launch.details
        tvLinkArticle.text = launch.urlArticle
        tvLinkWiki.text = launch.urlWiki
        tvLinkYoutube.text = launch.urlVideo

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (launch.isLaunchSuccess) {
                tvResult.setText(getString(R.string.success))
                tvResult.setTextColor(
                    getResources().getColor(
                        R.color.colorSuccess,
                        activity?.theme
                    )
                )
            } else {
                tvResult.setText(getString(R.string.failure))
                tvResult.setTextColor(getResources().getColor(R.color.colorFail, activity?.theme))
            }
        }
        tvLinkArticle.onClickUrl()
        tvLinkWiki.onClickUrl()
        tvLinkYoutube.onClickUrl()
    }

}


