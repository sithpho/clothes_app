package com.up.clothes_app.ui.wishlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.up.clothes_app.R
import com.up.clothes_app.adapter.WishListAdapter
import com.up.clothes_app.model.WishList
import kotlinx.android.synthetic.main.fragment_wish_list.*


class WishListFragment : Fragment() {

    private val nicWishList = listOf(
        WishList("Amazon", 20020, (R.drawable.apple)),
        WishList("KOI TE", 30021, (R.drawable.orangle)),
        WishList("Arizona", 300202, (R.drawable.amazon)),
        WishList("Apple", 300202, (R.drawable.apple)),
        WishList("Apple", 300202, (R.drawable.sith)),
        WishList("Apple", 300202, (R.drawable.puthea)),
        WishList("Apple", 300202, (R.drawable.sith)),
        WishList("Apple", 300202, (R.drawable.amazon)),
        WishList("Apple", 300202, (R.drawable.apple))

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_wish_list, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        wish_list_recyclerview.apply {
            layoutManager = GridLayoutManager(context,2)

            adapter = WishListAdapter(nicWishList)
        }
    }

    companion object {
        fun newInstance(): WishListFragment = WishListFragment()
    }
}