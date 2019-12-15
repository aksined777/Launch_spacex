package com.example_dk.exchange.myapplication.ui.fragment.launches

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example_dk.exchange.myapplication.entity.core.Launch
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

fun Launch.isSame(other: Launch): Boolean {
    return (this.id == other.id)
}


class LauncherDifferDelegateAdapter(
    onItemClickListener: (launch: Launch) -> Unit
) :
    AsyncListDifferDelegationAdapter<Any>(
        object : DiffUtil.ItemCallback<Any>() {
            override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
                return if (oldItem is Launch && newItem is Launch) {
                    oldItem.isSame(newItem)
                } else
                    false
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
                return if (oldItem is Launch && newItem is Launch) {
                    oldItem.id == newItem.id
                } else
                    false
            }

            override fun getChangePayload(oldItem: Any, newItem: Any) = Any()
        }
    ) {
    init {
        items = mutableListOf()
        delegatesManager.addDelegate(LaunchDelegateAdapter(onItemClickListener))
    }
}





