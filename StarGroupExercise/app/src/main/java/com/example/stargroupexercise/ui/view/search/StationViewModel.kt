package com.example.stargroupexercise.ui.view.search

import androidx.lifecycle.LiveData
import com.example.stargroupexercise.data.model.ObjStationData
import com.example.stargroupexercise.data.repository.StationApiRepository
import com.example.stargroupexercise.ui.base.BaseViewModel
import com.example.stargroupexercise.utils.Resource
import com.example.stargroupexercise.utils.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.regex.Pattern

class StationViewModel(
    private val apiRepository: StationApiRepository
) : BaseViewModel() {
    private val stations by lazy { SingleLiveEvent<Resource<List<ObjStationData>>>() }
    private val INPUT_VALIDATION by lazy { "^[a-zA-Z\\s]{3,50}$" }
    private val NUMBER_OF_MIN by lazy { 30 }
    val selectedStation by lazy { SingleLiveEvent<ObjStationData>() }

    fun getSelectedStationData(): SingleLiveEvent<ObjStationData>? {
        return selectedStation
    }

    val stationName: SingleLiveEvent<CharSequence>? = SingleLiveEvent()

    fun fetchStations(stationName: String) {
        launch {
            withContext(Dispatchers.IO) {
                stations.postValue(Resource.loading(null))
                apiRepository.getTrainsByStationName(stationName, NUMBER_OF_MIN).catch {
                    stations.postValue(Resource.error(it.toString(), null))
                }.collect {
                    if (it.stationData.isNullOrEmpty())
                        stations.postValue(Resource.error(it.toString(), null))
                    else
                        stations.postValue(Resource.success(it.stationData))
                }
            }
        }
    }


    fun getStations(): LiveData<Resource<List<ObjStationData>>> {
        return stations
    }
    fun retrieveStations() {
        return stations.call()
    }

    fun getSearchedStationName(): SingleLiveEvent<CharSequence>? {
        return stationName
    }

    fun isValidInput(inputText: String): Boolean {
        return Pattern.compile(INPUT_VALIDATION).matcher(inputText).matches()
    }

}

