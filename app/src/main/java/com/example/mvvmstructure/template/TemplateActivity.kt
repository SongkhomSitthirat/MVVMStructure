package com.example.mvvmstructure.template

import android.os.Bundle
import android.view.View
import com.example.mvvmstructure.R
import com.example.mvvmstructure.base.BaseActivity
import com.example.mvvmstructure.databinding.ActivityTemplateBinding

/**
 * Created by PrewSitthirat on 2018-11-29.
 */

class TemplateActivity : BaseActivity<ActivityTemplateBinding, TemplateViewModel>() {

    override var layoutResource: Int = R.layout.activity_template
    override var viewModel: TemplateViewModel = TemplateViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}