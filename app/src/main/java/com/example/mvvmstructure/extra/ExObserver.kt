package com.example.mvvmstructure.extra

import android.util.Log
import com.example.mvvmstructure.network.ErrorModel
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

/**
 * Created by PrewSitthirat on 2018-11-29.
 */

abstract class ExObserver<T> : Observer<T> {

    override fun onComplete() {
        onCompleted()
    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(t: T) {
        onSuccess(t)
    }

    override fun onError(throwable: Throwable) {
        try {
            if (throwable is HttpException) {
                if (throwable.code() == 404) {
//                    val errorModel = throwable.response().errorBody() as ErrorModel
                    val errorModel = ErrorModel()
                    onFail(throwable as Throwable, errorModel)
                } else {
                    val errorModel = ErrorModel().apply {
                        this.code = throwable.code().toString()
                        this.message = throwable.message()
                        this.description = throwable.localizedMessage
                    }
                    onFail(throwable as Throwable, errorModel)
                }
            }
            else if (throwable is SocketTimeoutException) {
                val errorModel = ErrorModel().apply {
                    this.code = "997"
                    this.message = "SocketTimeoutException"
                    this.description = "SocketTimeoutException"
                }
                onFail(throwable as Throwable, errorModel)
            }
            else if (throwable is IOException) {
                val errorModel = ErrorModel().apply {
                    this.code = "998"
                    this.message = "IOException"
                    this.description = "IOException"
                }
                onFail(throwable as Throwable, errorModel)
            } else {
                val errorModel = ErrorModel().apply {
                    this.code = "999"
                    this.message = "UnknownException"
                    this.description = throwable.message
                }
                onFail(throwable, errorModel)
            }
        } catch (e: Exception) {
            Log.d("Prew","Catch: ${e.message}")
        }
    }

    abstract fun onSuccess(responseModel: T)

    abstract fun onFail(throwable: Throwable, errorModel: ErrorModel)

    abstract fun onCompleted()
}