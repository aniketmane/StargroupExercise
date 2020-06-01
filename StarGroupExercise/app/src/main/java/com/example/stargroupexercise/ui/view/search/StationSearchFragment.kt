package com.example.stargroupexercise.ui.view.search

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stargroupexercise.R
import com.example.stargroupexercise.data.model.ObjStationData
import com.example.stargroupexercise.ui.adapter.StationListAdapter
import com.example.stargroupexercise.ui.view.BaseStationFragment
import com.example.stargroupexercise.utils.Resource
import com.example.stargroupexercise.utils.Status
import com.example.stargroupexercise.utils.hideKeyboard
import kotlinx.android.synthetic.main.fragment_station_search.*

class StationSearchFragment : BaseStationFragment(R.layout.fragment_station_search),
    StationListAdapter.OnItemClickListener, View.OnClickListener {
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
    }

    private fun setUpApiObserver() {
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
                rvStationList.visibility = View.VISIBLE
                progressBar.visibility = View.GONE
            }
            Status.LOADING -> {
                progressBar.visibility = View.VISIBLE
                rvStationList.visibility = View.INVISIBLE
            }
            Status.ERROR -> {
                //Handle Error
                progressBar.visibility = View.GONE
                Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setUpSearchDataObserver() {
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

        btSearch.setOnClickListener(this)
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

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btSearch -> {
                viewModel.stationName?.value = etTo.text.toString()
                setUpApiObserver()
                setUpSearchDataObserver()
                hideKeyboard()
            }
        }
    }

}