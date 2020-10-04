package com.up.clothes_app.ui.category

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.up.clothes_app.R
import com.up.clothes_app.ui.products.FoodsFragment
import com.up.clothes_app.ui.products.FruitesFragment
import com.up.clothes_app.ui.products.SportFragment
import kotlinx.android.synthetic.main.fragment_category.*


class CategoryFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_category, container, false)
        return v
    }
    @SuppressLint("UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        category_food.setOnClickListener {
            FoodsFragment().show(fragmentManager!!,"")
            Log.d("google","Hello Google")
        }
        category_sport.setOnClickListener{
            SportFragment().show(fragmentManager!!,"")
        }
        category_flower.setOnClickListener{
            FruitesFragment().show(fragmentManager!!,"")
        }
    }

    companion object {
        fun newInstance(): CategoryFragment = CategoryFragment()
    }
}