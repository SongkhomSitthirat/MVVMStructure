package com.example.mvvmstructure.extra

import android.os.SystemClock
import android.view.View

/**
 * Created by PrewSitthirat on 2018-11-29.
 */

abstract class ExOnClickListener : View.OnClickListener {

    private var mLastClickTime: Long = 0

    override fun onClick(v: View?) {
        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
            return
        } else {
            onViewClick()
        }
        mLastClickTime = SystemClock.elapsedRealtime()
    }

    abstract fun onViewClick()
}