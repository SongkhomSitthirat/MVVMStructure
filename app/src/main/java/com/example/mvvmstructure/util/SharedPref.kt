package com.example.mvvmstructure.util

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.mvvmstructure.language.Language

/**
 * Created by PrewSitthirat on 2018-11-29.
 */

class SharedPref {

    companion object {

        private const val SHARED_PREF_NAME = "SHARED_PREF_NAME"
        private const val DEFAULT_LANGUAGE = "DEFAULT_LANGUAGE"

        private fun getSharedPref(context: Context): SharedPreferences {
            return context.getSharedPreferences(SHARED_PREF_NAME, Application.MODE_PRIVATE)
        }

        fun getData(context: Context): String? {
            return if (getSharedPref(context).getString("KEY", "") == null) {
                null
            } else {
                getSharedPref(context).getString("KEY", "")
            }
        }

        fun setData(context: Context, string: String?) {
            getSharedPref(context).edit().putString("KEY", string).apply()
        }

        fun getDefaultLanguage(context: Context): String? {
            return if (getSharedPref(context).getString("KEY", "").isNullOrEmpty()) {
                Language.EN
            } else {
                getSharedPref(context).getString(DEFAULT_LANGUAGE, Language.EN)
            }
        }

        fun setDefaultLanguage(context: Context, string: String?) {
            getSharedPref(context).edit().putString(DEFAULT_LANGUAGE, string).apply()
        }
    }
}