package com.up.clothes_app.ui.login

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.google.android.material.snackbar.Snackbar
import com.up.clothes_app.MainActivity
import com.up.clothes_app.R
import com.up.clothes_app.model.AuthRequestAPI
import com.up.clothes_app.model.LoginRequestBody
import com.up.clothes_app.model.LoginResponse
import com.up.clothes_app.ui.products.SportFragment
import com.up.clothes_app.util.AESUtil
import com.up.clothes_app.util.PrefsUtil
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_category.*


class LoginActivity : AppCompatActivity(), AuthRequestAPI.AuthRequestAPICallback {
    var prefs: PrefsUtil? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btn_login.setOnClickListener {
            when {
                et_email_phone.text.isNullOrEmpty() -> {
                    Snackbar.make(findViewById(android.R.id.content),"Please input you Email or Phone number to login!", Snackbar.LENGTH_LONG).show()
                    return@setOnClickListener
                }
                et_password.text.isNullOrEmpty() -> {
                    Snackbar.make(findViewById(android.R.id.content),"Please input your password!", Snackbar.LENGTH_LONG).show()
                    return@setOnClickListener
                }
                else -> {
                    val KEY = "h@rdLosmLaKeyenc"
                    val IV = "h@rdLosmLavecenc"
                    val passwordEncryption:String = AESUtil.encrypt(KEY,IV,et_password.text.toString().trim())
                    val emailOrPhone: String = et_email_phone.text.toString().trim()
                    val modelLogin = LoginRequestBody(emailOrPhone,passwordEncryption)
                    AuthRequestAPI().authLoginRequestAPI(this,modelLogin)
                    Log.d("xxx","request: $modelLogin")
                }
            }
        }

        btn_signup.setOnClickListener{
            println("Hello ")
            val intent = Intent(this, SingUpActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onAuthLoginRequestAPIResponseSuccess(data: LoginResponse) {
        prefs!!.userToken = data.data!!.accessToken.toString()
        Log.d("xxx","$data")
    }

    override fun onAuthLoginRequestAPIResponseError(errorMessage: Throwable) {
        Log.d("xxx","${errorMessage.message}")
    }
}
