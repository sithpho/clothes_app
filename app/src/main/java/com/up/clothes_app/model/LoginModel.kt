package com.up.clothes_app.model

import android.annotation.SuppressLint
import com.up.clothes_app.webservice.WebService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AuthRequestAPI {
    private var mAuthLoginRequestAPICallback: AuthRequestAPICallback? = null
    @SuppressLint("CheckResult")
    fun authLoginRequestAPI( mAuthLoginRequestAPICallback:AuthRequestAPICallback, mAuthLogin:LoginRequestBody) {
        this.mAuthLoginRequestAPICallback = mAuthLoginRequestAPICallback

        WebService.requestLocal().getAuthLoginRequestServices(mAuthLogin)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                onAuthLoginRequestAPIResponseSuccess(it)
            }, {
                onAuthLoginRequestAPIResponseError(it)
            })
    }

    interface AuthRequestAPICallback{
        fun onAuthLoginRequestAPIResponseSuccess(data: LoginResponse)
        fun onAuthLoginRequestAPIResponseError(errorMessage: Throwable)
    }

    private fun onAuthLoginRequestAPIResponseSuccess(data: LoginResponse) {
        this.mAuthLoginRequestAPICallback?.onAuthLoginRequestAPIResponseSuccess(data)
    }

    private fun onAuthLoginRequestAPIResponseError(errorMessage: Throwable) {
        this.mAuthLoginRequestAPICallback?.onAuthLoginRequestAPIResponseError(errorMessage)
    }

}

data class LoginRequestBody(
    val phoneNumber : String? = "",
    val password : String? = ""
)

data class LoginResponse(
    val data: Result? = Result() ,
    val response: Response? = Response()
)

data class Result (
   val expireIn : Long? = 0,
   val accessToken : String? = "",
   val tokenType : String? = ""
)

data class Response (
    val code : Int? = 0,
    val message : String ? = ""
)