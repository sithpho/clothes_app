package com.up.clothes_app.ui.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.up.clothes_app.R
import com.up.clothes_app.adapter.ClothesAdapter
import com.up.clothes_app.model.Clothes
import kotlinx.android.synthetic.main.fragment_clothes.*


class ClothesFragment : Fragment() {

    private val listClothes = listOf(
        Clothes(R.drawable.amazon ,"Hello Testing", 1.0,"Food USA ", 1f , 2),
        Clothes(R.drawable.food ,"Food Cola", 1.0,"Food USA ", 1f , 2),
        Clothes(R.drawable.apple ,"Apple Cola", 1.0,"Food USA ", 1f , 2),
        Clothes(R.drawable.orangle ,"Orange Cola", 1.0,"Food USA ", 1f , 2),
        Clothes(R.drawable.sport ,"Sport Cola", 1.0,"Food USA ", 1f , 2),
        Clothes(R.drawable.crystal ,"Crystal Cola", 1.0,"Food USA ", 1f , 2),
        Clothes(R.drawable.amazon ,"Amazon Cola", 1.0,"Food USA ", 1f , 2),
        Clothes(R.drawable.apple ,"Apple Cola", 1.0,"Food USA ", 1f , 2)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_clothes, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clothes_recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ClothesAdapter(listClothes)
        }
    }

    companion object {
        fun newInstance(): ClothesFragment = ClothesFragment()
    }
}