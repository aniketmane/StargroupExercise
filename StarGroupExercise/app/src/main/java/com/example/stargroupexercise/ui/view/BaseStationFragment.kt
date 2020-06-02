package com.example.stargroupexercise.ui.view

import com.example.stargroupexercise.data.api.NetworkBuilder
import com.example.stargroupexercise.data.repository.StationApiRepositoryImpl
import com.example.stargroupexercise.ui.base.BaseFragment
import com.example.stargroupexercise.ui.base.ViewModelFactory
import com.example.stargroupexercise.ui.view.search.StationViewModel

open class BaseStationFragment(layoutId: Int) : BaseFragment<StationViewModel>(layoutId) {
    override val viewModelClass: Class<StationViewModel> = StationViewModel::class.java

    override val vmFactory: ViewModelFactory =
        ViewModelFactory(StationApiRepositoryImpl(NetworkBuilder.apiService))
    
}