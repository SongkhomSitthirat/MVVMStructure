package com.example.mvvmstructure.base

import android.app.Activity
import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

/**
 * Created by PrewSitthirat on 2018-11-29.
 */

abstract class BaseFragment<B : ViewDataBinding, VM : ViewModel> : Fragment() {

    abstract var layoutResource: Int
    abstract var viewModel: VM
    lateinit var binding: B
    lateinit var mActivity: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mActivity = activity!!
        binding = DataBindingUtil.inflate(inflater,layoutResource, container, false)
        viewModel = ViewModelProviders.of(this).get(viewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}