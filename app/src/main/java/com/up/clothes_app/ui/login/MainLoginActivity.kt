package com.up.clothes_app.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.up.clothes_app.R
import kotlinx.android.synthetic.main.activity_main_login.*

class MainLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login)
        main_login.setOnClickListener{
            println("Hello ")
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


        btn_create_account.setOnClickListener{
//            val bottomSheetDialog = BottomSheetDialog(this)
////            bottomSheetDialog.setContentView(R.layout.dialog_create_account)

            SingUpDialog().show(supportFragmentManager,"")
        }

    }
}
