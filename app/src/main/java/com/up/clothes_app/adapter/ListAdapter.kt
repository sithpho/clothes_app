package com.up.clothes_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.up.clothes_app.R

class ListAdapter(private val list: List<com.up.clothes_app.ui.notifications.Movie>)
    : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie: com.up.clothes_app.ui.notifications.Movie = list[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = list.size

}

class MovieViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_items, parent, false)) {
    private var mTitleView: TextView? = null
    private var mYearView: TextView? = null
    private var listImage: ImageView? = null


    init {
        mTitleView = itemView.findViewById(R.id.list_title)
        mYearView = itemView.findViewById(R.id.list_description)
        listImage = itemView.findViewById(R.id.list_image)


    }

    fun bind(movie: com.up.clothes_app.ui.notifications.Movie) {
        mTitleView?.text = movie.title
        mYearView?.text = movie.year.toString()
        listImage?.setImageResource(movie.image)
    }

}