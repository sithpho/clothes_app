package com.up.clothes_app.ui.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.up.clothes_app.R
import kotlinx.android.synthetic.main.fragment_setting.*

class SettingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_setting, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            btn_logout.setOnClickListener {
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent)
            }
    }
}