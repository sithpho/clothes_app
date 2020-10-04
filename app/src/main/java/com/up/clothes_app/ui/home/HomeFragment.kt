package com.up.clothes_app.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.up.clothes_app.R
import com.up.clothes_app.adapter.NewFeedAdapter
import com.up.clothes_app.adapter.adaterlayout.SlideAdapter
import com.up.clothes_app.model.ListProduct
import com.up.clothes_app.model.MainModel
import com.up.clothes_app.model.Products
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)

        return root
    }

    @SuppressLint("WrongConstant")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recyclerViewDuckBoard.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL , false)

        val product = ArrayList<MainModel>()

        val item = ArrayList<Products>()
        item.add(Products(R.drawable.orangle,"ABC 001",2.3 , 1))
        item.add(Products(R.drawable.apple,"Angkor 002",2.3 , 1))
        item.add(Products(R.drawable.amazon,"Tiger 003",2.3 , 1))
        item.add(Products(R.drawable.food,"Water 004 ",2.3 , 1))
        item.add(Products(R.drawable.orangle,"ABC 005",2.3 , 1))
        item.add(Products(R.drawable.food,"Red 006",2.3 , 1))
        item.add(Products(R.drawable.amazon,"ABC 0007",2.3 , 1))
        item.add(Products(R.drawable.orangle,"ABC 008",2.3 , 1))
        item.add(Products(R.drawable.apple,"ABC 009",2.3 , 1))
        item.add(Products(R.drawable.food,"Angkor 0010",2.3 , 1))
        item.add(Products(R.drawable.amazon,"Tiger 0111",2.3 , 1))
        item.add(Products(R.drawable.orangle,"Water 0012  ",2.3 , 1))
        item.add(Products(R.drawable.food,"ABC 00013",2.3 , 1))
        item.add(Products(R.drawable.orangle,"Red 00014",2.3 , 1))
        item.add(Products(R.drawable.apple,"ABC 00015",2.3 , 1))
        item.add(Products(R.drawable.orangle,"ABC Beer",2.3 , 1))

        val products = ArrayList<ListProduct>()
        products.add(ListProduct(R.drawable.amazon ,"Coca Cola", 1.0,"Food USA ", 1f , 2))
        products.add(ListProduct(R.drawable.food,"Water", 2.0,"Food USA ", 2f , 2 ))
        products.add(ListProduct(R.drawable.orangle ,"Coca Cola", 3.0,"Food USA ", 1f , 2 ))
        products.add(ListProduct(R.drawable.crystal,"Tiger Crystal ", 4.0,"Beer Home ", 2f , 2 ))
        products.add(ListProduct(R.drawable.apple,"Tiger Crystal ", 4.0,"Beer Home ", 2f , 2 ))

        product.add(MainModel(1,item,products))
        product.add(MainModel(2,item,products))
        product.add(MainModel(3,item,products))
        //product.add(MainModel(4,item,products))
        // update context
        val adapter = NewFeedAdapter(context,product )

        val adapterSlideShow = SlideAdapter()
        imageSlider.sliderAdapter = adapterSlideShow
        recyclerViewDuckBoard.adapter = adapter
    }
}

