package com.up.clothes_app.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.up.clothes_app.R
import com.up.clothes_app.adapter.ListAdapter
import kotlinx.android.synthetic.main.fragment_notifications.*

data class Movie(val title: String, val year: Int, val image: Int=0)

class NotificationsFragment : Fragment() {

    private val nicCageMovies = listOf(
        Movie("Testing Arizona", 1987, (R.drawable.crystal)),
        Movie("Apple Arizona", 1987, (R.drawable.bacelona)),
        Movie("Orange Arizona", 1987, (R.drawable.food_first)),
        Movie("Good  Arizona", 1987, (R.drawable.flower_first)),
        Movie("Testing Arizona", 1987, (R.drawable.griezmann)),
        Movie("Raising Arizona", 1987, (R.drawable.amazon)),
        Movie("Love Arizona", 1987, (R.drawable.apple))
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_notifications, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list_recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ListAdapter(nicCageMovies)
        }
    }

    companion object {
        fun newInstance(): NotificationsFragment = NotificationsFragment()
    }
}