package com.example.stargroupexercise.ui.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.stargroupexercise.R
import com.example.stargroupexercise.databinding.FragmentStationDetailBinding
import com.example.stargroupexercise.ui.view.BaseStationFragment


class StationDetailFragment :
    BaseStationFragment(R.layout.fragment_station_detail) {

    private val detailViewModel: StationDetailViewModel by lazy { StationDetailViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentStationDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_station_detail, container, false);
        binding.stationDetails = detailViewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupStationDataObserver()
    }

    private fun setupStationDataObserver() {
        viewModel.getSelectedStationData()?.observe(viewLifecycleOwner, Observer {
            detailViewModel.setStationFullName(it.Stationfullname)
            detailViewModel.setDirections(it.Direction)
            detailViewModel.setExpArrivalTime(it.Exparrival)
            detailViewModel.setExpDeparture(it.Expdepart)
            detailViewModel.setStatus(it.Status)
            detailViewModel.setTo(it.Destination)
            detailViewModel.setFrom(it.Origin)
            detailViewModel.notifyChange()
        })
    }

}