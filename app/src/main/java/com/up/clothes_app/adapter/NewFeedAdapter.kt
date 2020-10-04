package com.up.clothes_app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.up.clothes_app.R
import com.up.clothes_app.RecyclerViewItemClick
import com.up.clothes_app.adapter.adaterlayout.AdapterListNewFeed
import com.up.clothes_app.adapter.adaterlayout.ProductAdapter
import com.up.clothes_app.model.ListProduct
import com.up.clothes_app.model.MainModel
import com.up.clothes_app.model.Products


class NewFeedAdapter(val context: Context?, private val newFeedList: ArrayList<MainModel>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        val slide: Int = 0
        val products: Int = 1
        val newfeed: Int = 2

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == products) {
            ProductViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_product, parent,false))

        } else {
            NewFeedViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.new_feed_layout , parent , false))
        }
    }

    override fun getItemCount(): Int {
        return newFeedList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder.itemViewType) {
            products -> {
                val productViewHolder = holder as ProductViewHolder
                productViewHolder.bindViews(context, newFeedList[position].categories)
            } else -> {
            val newFeedViewHolder = holder as NewFeedViewHolder
                newFeedViewHolder.bindView(context,newFeedList[position].items)
        }
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (newFeedList[position].type == 0) {
            return slide
        } else if (newFeedList[position].type == 1){
            return products
        } else {
            return newfeed
        }
    }


    inner class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) ,
        RecyclerViewItemClick {

        override fun onItemClick(position: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        fun bindViews(context: Context?, list: ArrayList<Products>){

            val recyclerView = itemView.findViewById<RecyclerView>(R.id.rclProduct)
            recyclerView.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)

            val adapter = ProductAdapter(list)
            recyclerView.adapter = adapter
        }
    }

   inner class NewFeedViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), RecyclerViewItemClick {
       override fun onItemClick(position: Int) {
           TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
       }
       fun bindView(context: Context?, list:  ArrayList<ListProduct>) {

            val recyclerView = itemView.findViewById<RecyclerView>(R.id.rclNewFeed)
            recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL , false)
            val adapter = AdapterListNewFeed(list,this)

            recyclerView.adapter  = adapter
        }
    }
}


