package com.example_dk.exchange.myapplication.ui.common

import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

open class BaseRVAdapter : ListDelegationAdapter<MutableList<Any>>() {

    init {
        items = mutableListOf()
    }

    fun addDelegate(delegate: AdapterDelegate<MutableList<Any>>) {
        delegatesManager.addDelegate(delegate)
    }

    fun addItemsFromStart(data: List<Any>) {
        items.addAll(0, data)
        notifyItemRangeChanged(0, data.size)
    }

    fun removeItem(pos: Int) {
        items.removeAt(pos)
        notifyItemRemoved(pos)
    }

    fun addItem(pos: Int, item: Any) {
        items.add(pos, item)
        notifyItemInserted(pos)
    }

    fun setData(data: List<Any>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }
}