package com.up.clothes_app.adapter.adaterlayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.up.clothes_app.R
import com.up.clothes_app.RecyclerViewItemClick
import com.up.clothes_app.model.ListProduct

class AdapterListNewFeed(private val newFeed :ArrayList <ListProduct>, val click : RecyclerViewItemClick): RecyclerView.Adapter<AdapterListNewFeed.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            //val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_item, parent, false)
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return newFeed.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val newFeeds: ListProduct = newFeed[position]
        holder.listTitle.text = newFeeds.itemName
        holder.listDes.text = newFeeds.itemDes
        holder.listRate.rating = newFeeds.Rate
        holder.listPrice.text = newFeeds.itemPrice.toString()
        holder.listImage.setImageResource(newFeeds.image)
//        holder.itemView.setOnClickListener{
//            click.onItemClick(position)
//        }
    }


    class ViewHolder( itemView: View) : RecyclerView.ViewHolder(itemView){

        val listTitle = itemView.findViewById(R.id.titlesFood) as TextView
        val listDes = itemView.findViewById(R.id.desFood) as TextView
        val listRate = itemView.findViewById(R.id.ratingBar) as RatingBar
        val listPrice = itemView.findViewById(R.id.txtPriceList) as TextView
        val listImage = itemView.findViewById(R.id.image_food) as ImageView
    }
}