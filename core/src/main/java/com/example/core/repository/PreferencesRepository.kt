package com.example.core.repository

import android.content.SharedPreferences
import com.example.core.util.Constants.ISLOGIN
import com.example.core.util.Constants.TOKEN
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesRepository @Inject constructor(private val pref: SharedPreferences){
    private val editor = pref.edit()

    fun getIsLogin() = ISLOGIN.getBooleanLogin()
    fun getToken() = TOKEN.getString()

    fun setIsLogin(login: Boolean) {
        ISLOGIN.put(login)
    }

    fun setToken(token: String) {
        TOKEN.put(token)
    }

    private fun String.put(boolean: Boolean) {
        editor.putBoolean(this, boolean)
        editor.apply()
    }

    private fun String.put(data:String){
        editor.putString(this, data)
        editor.apply()
    }

    fun clearData() {
        editor.clear()
        editor.commit()
    }

    private fun String.getBooleanLogin() = pref.getBoolean(this, false)


    private fun String.getString() = pref.getString(this, "")

}