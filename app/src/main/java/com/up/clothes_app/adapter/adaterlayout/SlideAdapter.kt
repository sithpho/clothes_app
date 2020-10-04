package com.up.clothes_app.adapter.adaterlayout

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.smarteist.autoimageslider.SliderViewAdapter
import com.up.clothes_app.R

class SlideAdapter:SliderViewAdapter<SlideAdapter.SliderAdapterVH>() {

    override fun onCreateViewHolder(parent: ViewGroup?): SliderAdapterVH {
//        val view = LayoutInflater.from(parent?.context).inflate(R.layout.fragment_slide, parent, false)
//                return SliderAdapterVH(view)

        return SliderAdapterVH(LayoutInflater.from(parent!!.context).inflate(R.layout.fragment_slide , null))
    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(viewHolder: SliderAdapterVH?, position: Int) {

        when (position) {
            0 -> Glide.with(viewHolder!!.itemView)
                .load(R.drawable.category_flower)
                .fitCenter()
                .into(viewHolder.imageViewBackground)
            1 -> Glide.with(viewHolder!!.itemView)
                .load(R.drawable.sport)
                .fitCenter()
                .into(viewHolder.imageViewBackground)
            2 -> Glide.with(viewHolder!!.itemView)
                .load(R.drawable.slide_show_first)
                .fitCenter()
                .into(viewHolder.imageViewBackground)
            else -> Glide.with(viewHolder!!.itemView)
                .load(R.drawable.amazon)
                .fitCenter()
                .into(viewHolder.imageViewBackground)
        }

    }

    override fun getCount(): Int {
        return 4
    }

    class SliderAdapterVH(val itemView: View) : SliderViewAdapter.ViewHolder(itemView) {
        val imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider) as ImageView
    }
}