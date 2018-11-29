package com.example.mvvmstructure.network

import android.content.Context
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by PrewSitthirat on 2018-11-29.
 */

object ApiService {

    private val gson = GsonBuilder()
//                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
        .setLenient()
        .setPrettyPrinting()
        .create()

    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    private fun getOkHttpClient(context: Context): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(ServiceProperties.TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(ServiceProperties.TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(ServiceProperties.TIMEOUT, TimeUnit.SECONDS)
            .addNetworkInterceptor(getLoggingInterceptor())
            .addInterceptor(getLoggingInterceptor())
//            .addInterceptor(Interceptor { chain ->
//                var request = chain?.request()?.newBuilder()
//                if (!SharedPref.getAccessToken(context).isNullOrEmpty()) {
//                    request?.addHeader("Authorization", SharedPref.getAccessToken(context)!!)
//                }
//                request?.addHeader("Accept-Language", Word.getLang())
//                return@Interceptor chain?.proceed(request?.build())!!
//            })
        return okHttpClient.build()
    }

    private fun getRetrofit(context: Context): Retrofit {
        return Retrofit.Builder()
            .client(getOkHttpClient(context))
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(ServiceProperties.getBaseUrl())
            .build()
    }

    fun getEndpointInterface(context: Context): ServiceEndpointInterface {
        return getRetrofit(context).create(ServiceEndpointInterface::class.java)
    }
}