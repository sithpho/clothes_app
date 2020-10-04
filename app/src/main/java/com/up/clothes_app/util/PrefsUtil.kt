package com.up.clothes_app.util

import android.content.Context
import android.content.SharedPreferences

class PrefsUtil(context: Context) {

    val PREFS_FILENAME = "user.prefs"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0)

    private val USERTOKEN = "USER TOKEN"

    var userToken: String
        get() = prefs.getString(USERTOKEN,"")!!
        set(value) = prefs.edit().putString(USERTOKEN,value).apply()

}