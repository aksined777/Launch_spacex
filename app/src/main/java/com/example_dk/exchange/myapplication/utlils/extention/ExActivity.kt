package com.example_dk.exchange.myapplication.utlils.extention

import android.app.Activity
import android.graphics.Color
import android.view.View
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.app_activity.*


fun Activity.getRootView(): View {
    return findViewById<View>(android.R.id.content)
}

fun Activity?.showMsg(msg: String) {
    this?.getRootView()?.let {
        Snackbar.make(it, msg, 3000)
            .setActionTextColor(Color.WHITE)
            .show()
    }
}

fun Activity.showProgress(show: Boolean) {
    this.refresher.isRefreshing = show
}


fun Activity.swipeEnabled(check: Boolean) {
    this.refresher.isEnabled = check
}
