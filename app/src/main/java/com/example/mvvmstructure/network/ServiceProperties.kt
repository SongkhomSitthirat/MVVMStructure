package com.example.mvvmstructure.network

import com.example.mvvmstructure.BuildConfig

/**
 * Created by PrewSitthirat on 2018-11-29.
 */

class ServiceProperties {

    companion object {

        private const val BASE_URL_DEV: String = ""
        private const val BASE_URL_PRO: String = ""
        const val TIMEOUT: Long = 10

        fun getBaseUrl(): String {
            return if (BuildConfig.IS_DEV) {
                BASE_URL_DEV
            } else {
                BASE_URL_PRO
            }
        }
    }
}