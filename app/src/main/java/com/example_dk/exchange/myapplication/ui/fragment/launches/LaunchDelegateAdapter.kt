package com.example_dk.exchange.myapplication.ui.fragment.launches

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example_dk.exchange.myapplication.R
import com.example_dk.exchange.myapplication.entity.core.Launch
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_launcher.view.*


class LaunchDelegateAdapter(private val clickListener: (launch: Launch) -> Unit) :
    AdapterDelegate<MutableList<Any>>() {

    override fun isForViewType(items: MutableList<Any>, position: Int): Boolean {
        return (items[position] is Launch)
    }


    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.item_launcher, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        items: MutableList<Any>,
        position: Int,
        viewHolder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) =
        (viewHolder as ViewHolder).bind(items[position] as Launch)

    private inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private lateinit var item: Launch

        init {
            view.setOnClickListener {
                clickListener(item)
            }
        }

        fun bind(item: Launch) {
            this.item = item
            Picasso.with(itemView.ivLogo.getContext()).load(item.urlSmallLogo)
                .placeholder(R.drawable.progress_animation)
                .fit()
                .into(itemView.ivLogo)
            itemView.tvMission.text = item.mission_name
            itemView.tvRocket.text = item.rocketName
            itemView.tvDate.text = item.date
        }
    }

}
