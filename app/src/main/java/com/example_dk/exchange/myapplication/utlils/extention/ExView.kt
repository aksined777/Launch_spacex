package com.example_dk.exchange.myapplication.utlils.extention

import android.content.Intent
import android.net.Uri
import android.widget.ImageView
import android.widget.TextView
import com.example_dk.exchange.myapplication.R
import com.squareup.picasso.Picasso

fun TextView?.onClickUrl() {
    this?.let {
        val url: String = it.text.toString()
        it.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            it.context?.startActivity(intent)
        }
    }
}

fun ImageView?.load(url: String) {
    this?.let {
        Picasso.with(it.getContext()).load(url)
            .placeholder(R.drawable.progress_animation)
            .fit()
            .into(it)
    }
}