package com.example.mvvmstructure

import com.example.mvvmstructure.base.BaseApplication
import com.example.mvvmstructure.language.Language
import com.example.mvvmstructure.util.SharedPref
import com.example.mvvmstructure.util.Singleton

/**
 * Created by PrewSitthirat on 2018-11-29.
 */

class MainApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        Singleton.context = applicationContext
        Language.language = SharedPref.getDefaultLanguage(applicationContext) ?: Language.EN
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}