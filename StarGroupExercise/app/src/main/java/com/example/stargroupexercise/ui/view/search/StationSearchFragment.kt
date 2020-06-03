package com.example.stargroupexercise.ui.view.search

import android.os.Bundle
import android.util.Log
import android.view.View.*
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stargroupexercise.R
import com.example.stargroupexercise.data.model.ObjStationData
import com.example.stargroupexercise.ui.adapter.StationListAdapter
import com.example.stargroupexercise.ui.view.BaseStationFragment
import com.example.stargroupexercise.utils.*
import kotlinx.android.synthetic.main.fragment_station_search.*
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class StationSearchFragment : BaseStationFragment(R.layout.fragment_station_search),
    StationListAdapter.OnItemClickListener {
    private val adapter: StationListAdapter by lazy {
        StationListAdapter(
            arrayListOf(),
            this@StationSearchFragment
        )
    }
    private val navController: NavController by lazy { Navigation.findNavController(this.requireView()) }
    private lateinit var rvStationList: RecyclerView
    private lateinit var btSearch: AppCompatButton

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupUI()
        setupApiObserver()
    }

    private fun setupApiObserver() {
        viewModel.getStations()
            .observe(viewLifecycleOwner, Observer(this::applyApiObserver))
    }

    private fun applyApiObserver(it: Resource<List<ObjStationData>>) {
        when (it.status) {
            Status.SUCCESS -> {
                it.data?.let { it ->
                    Log.d("TestData", it.toString());
                    renderList(it)
                }
                uiVisibility(GONE, VISIBLE, GONE)
            }
            Status.LOADING -> {
                uiVisibility(VISIBLE, INVISIBLE, GONE)
            }
            Status.ERROR -> {
                //Handle Error
                uiVisibility(GONE, INVISIBLE, VISIBLE)
            }
        }
    }

    private fun uiVisibility(
        pbVisibility: Int,
        rvVisibility: Int,
        dataNotAvailableVisibility: Int
    ) {
        progressBar.visibility = pbVisibility
        rvStationList.visibility = rvVisibility
        tvDataNotAvailable.visibility = dataNotAvailableVisibility
    }

    private fun setupSearchDataObserver() {
        viewModel.getSearchedStationName()
            ?.observe(viewLifecycleOwner, Observer {
                getStations(it.toString())
            })
    }

    private fun setupUI() {
        rvStationList = this.requireView().findViewById(R.id.rvStationList)
        btSearch = this.requireView().findViewById(R.id.btSearch)
        rvStationList.layoutManager = LinearLayoutManager(activity)
        rvStationList.addItemDecoration(
            DividerItemDecoration(
                rvStationList.context,
                (rvStationList.layoutManager as LinearLayoutManager).orientation
            )
        )
        rvStationList.adapter = adapter

        btSearch.onClicked().debounce(viewModel.DEBOUNCE_TIMEOUT).onEach {
            if (viewModel.isValidInput(etTo.text.toString()) && requireContext().isConnected()) {
                viewModel.stationName?.value = etTo.text.toString().trim()
                setupSearchDataObserver()
                hideKeyboard()
            } else {
                if (!requireContext().isConnected()) {
                    uiVisibility(GONE, INVISIBLE, VISIBLE)
                    tvDataNotAvailable.setText(R.string.network_unavailable)
                } else {
                    etTo.error = getString(R.string.invalid_input)
                    uiVisibility(GONE, INVISIBLE, INVISIBLE)
                }
            }
        }.launchIn(lifecycleScope)
    }

    private fun renderList(stations: List<ObjStationData>) {
        adapter.addData(stations)
        adapter.notifyDataSetChanged()
    }

    private fun getStations(stationName: String) {
        viewModel.fetchStations(stationName)
    }

    override fun onItemClicked(stationData: ObjStationData) {
        viewModel.selectedStation.value = stationData
        navController.navigate(
            R.id.action_stationSearchFragment_to_stationDetailsFragment
        )
    }


}