package com.example_dk.exchange.myapplication.extention

import android.app.Activity
import android.graphics.Color
import android.view.View
import com.google.android.material.snackbar.Snackbar


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

