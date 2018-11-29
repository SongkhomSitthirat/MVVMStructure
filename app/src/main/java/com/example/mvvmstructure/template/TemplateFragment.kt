package com.example.mvvmstructure.template

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvvmstructure.R
import com.example.mvvmstructure.base.BaseFragment
import com.example.mvvmstructure.databinding.FragmentTemplateBinding

/**
 * Created by PrewSitthirat on 2018-11-29.
 */

class TemplateFragment : BaseFragment<FragmentTemplateBinding, TemplateFragmentViewModel>() {

    override var layoutResource: Int = R.layout.fragment_template
    override var viewModel: TemplateFragmentViewModel = TemplateFragmentViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}