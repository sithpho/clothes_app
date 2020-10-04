package com.up.clothes_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.up.clothes_app.R
import com.up.clothes_app.model.Category

class CategoryAdapter(private val list: List<Category>)
    : RecyclerView.Adapter<CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CategoryViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category: Category = list[position]
        holder.bind(category)
    }

    override fun getItemCount(): Int = list.size

}

class CategoryViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.category_item, parent, false)) {
    private var mTitleView: TextView? = null
    private var mYearView: TextView? = null
    private var listImage: ImageView? = null


    init {
        mTitleView = itemView.findViewById(R.id.category_title)
        mYearView = itemView.findViewById(R.id.category_description)
        listImage = itemView.findViewById(R.id.category_image)


    }

    fun bind(movie: Category) {
        mTitleView?.text = movie.title
        mYearView?.text = movie.year.toString()
        listImage?.setImageResource(movie.image)
    }

}