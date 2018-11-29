package com.example.mvvmstructure

import android.os.Bundle
import android.view.View
import com.example.mvvmstructure.base.BaseActivity
import com.example.mvvmstructure.databinding.ActivityMainBinding
import com.example.mvvmstructure.extra.ExOnClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override var layoutResource: Int = R.layout.activity_main
    override var viewModel: MainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
