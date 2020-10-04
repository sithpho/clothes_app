package com.up.clothes_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.up.clothes_app.R
import com.up.clothes_app.model.Clothes

class ClothesAdapter(private val list: List<Clothes>)
    : RecyclerView.Adapter<ClothesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClothesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ClothesViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ClothesViewHolder, position: Int) {
        val clothes: Clothes = list[position]
        holder.bind(clothes)
    }

    override fun getItemCount(): Int = list.size

}

class ClothesViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.clothes_item, parent, false)) {
    private var mTitleView: TextView? = null
    private var mDescriptionView: TextView? = null
    private var mPriceView: TextView? = null
    private var mRateView: RatingBar? = null
    private var mImage: ImageView? = null


    init {
        mTitleView = itemView.findViewById(R.id.clothes_title)
        mDescriptionView = itemView.findViewById(R.id.clothes_description)
        mPriceView = itemView.findViewById(R.id.clothes_price)
        mRateView = itemView.findViewById(R.id.clothes_rate)
        mImage = itemView.findViewById(R.id.clothes_image)



    }

    fun bind(clothes: Clothes) {
        mTitleView?.text = clothes.itemName
        mDescriptionView?.text = clothes.itemDes
        mPriceView?.text = clothes.itemPrice.toString()
        mRateView?.rating = clothes.Rate
        mImage?.setImageResource(clothes.image)
    }

}