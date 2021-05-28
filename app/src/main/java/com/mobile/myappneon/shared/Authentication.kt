package com.mobile.myappneon.shared

import android.content.Context
import android.content.SharedPreferences

internal class Authentication private constructor(context: Context) {

    private val sharedPreferences: SharedPreferences? = context.getSharedPreferences("Preference", Context.MODE_PRIVATE)

    fun saveData(key: String?, value: String?) {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.putString(key, value)
        prefsEditor.commit()
    }

    fun getData(key: String?): String? {
        return if (sharedPreferences != null) {
            sharedPreferences.getString(key, "")
        } else ""
    }

    companion object {
        private var yourPreference: Authentication? = null
        fun getInstance(context: Context): Authentication? {
            if (yourPreference == null) {
                yourPreference = Authentication(context)
            }
            return yourPreference
        }
    }
}