package com.example.stargroupexercise.ui.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

abstract class BaseFragment<VM : BaseViewModel>(fragmentLayout: Int) : Fragment(fragmentLayout) {
    abstract val viewModelClass: Class<VM>

    lateinit var viewModel: VM
        private set

    abstract val vmFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(
            this.activity!!,
            vmFactory
        ).get(viewModelClass)
    }
}