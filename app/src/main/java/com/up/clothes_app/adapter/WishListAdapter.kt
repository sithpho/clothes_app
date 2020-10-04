package com.up.clothes_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.up.clothes_app.R
import com.up.clothes_app.model.WishList

class WishListAdapter(private val list: List<WishList>)
    : RecyclerView.Adapter<WishListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return WishListViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: WishListViewHolder, position: Int) {
        val wishList: WishList = list[position]
        holder.bind(wishList)
    }

    override fun getItemCount(): Int = list.size

}

class WishListViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.wish_list_items, parent, false)) {
    private var mTitleView: TextView? = null
    private var mYearView: TextView? = null
    private var listImage: ImageView? = null


    init {
        mTitleView = itemView.findViewById(R.id.wish_list_name)
        //mYearView = itemView.findViewById(R.id.wish_list_description)
        listImage = itemView.findViewById(R.id.wish_list_image)


    }

    fun bind(wishList:WishList) {
        mTitleView?.text = wishList.title
        //mYearView?.text = wishList.year.toString()
        listImage?.setImageResource(wishList.image)
    }

}