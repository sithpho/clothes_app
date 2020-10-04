package com.up.clothes_app.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.up.clothes_app.R
import kotlinx.android.synthetic.main.activity_sing_up.*

class SingUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)

        btn_create.setOnClickListener{
            println("Hello ")
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
