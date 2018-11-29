package com.example.mvvmstructure.base

import android.os.Bundle
import android.os.SystemClock
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

/**
 * Created by PrewSitthirat on 2018-11-29.
 */

abstract class BaseActivity<B : ViewDataBinding, VM : ViewModel> : AppCompatActivity() {

    abstract var layoutResource: Int
    abstract var viewModel: VM
    lateinit var binding: B
    private var mLastClickTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResource)
        viewModel = ViewModelProviders.of(this).get(viewModel::class.java)
    }
}