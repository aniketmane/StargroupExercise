package com.example.stargroupexercise.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.stargroupexercise.data.repository.StationApiRepository
import com.example.stargroupexercise.ui.view.search.StationViewModel


@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val apiRepository: StationApiRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StationViewModel::class.java)) {
            return StationViewModel(
                apiRepository
            ) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}