package com.example.mvvmstructure.base

import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by PrewSitthirat on 2018-11-29.
 */

open class BaseViewModel : ViewModel() {

    inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object : TypeToken<T>() {}.type)
}