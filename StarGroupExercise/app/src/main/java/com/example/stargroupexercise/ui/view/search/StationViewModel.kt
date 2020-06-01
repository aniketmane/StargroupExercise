package com.example.stargroupexercise.ui.view.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.stargroupexercise.data.model.ObjStationData
import com.example.stargroupexercise.data.repository.StationApiRepository
import com.example.stargroupexercise.ui.view.StationSharedViewModel
import com.example.stargroupexercise.utils.Resource
import com.example.stargroupexercise.utils.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StationViewModel(
    private val apiRepository: StationApiRepository
) : StationSharedViewModel() {
    private val stations = SingleLiveEvent<Resource<List<ObjStationData>>>()
    val selectedStation = MutableLiveData<ObjStationData>()

    fun getSelectedStationData(): LiveData<ObjStationData>? {
        return selectedStation
    }

    val stationName: MutableLiveData<CharSequence>? = MutableLiveData<CharSequence>()

    fun fetchStations(stationName: String) {
        launch {
            withContext(Dispatchers.IO) {
                stations.postValue(Resource.loading(null))
                apiRepository.getTrainsByStationName(stationName, 20).catch {
                    stations.postValue(Resource.error(it.toString(), null))
                }.collect {
                    stations.postValue(Resource.success(it.stationData))
                }
            }
        }
    }


    fun getStations(): LiveData<Resource<List<ObjStationData>>> {
        return stations
    }

    fun getSearchedStationName(): LiveData<CharSequence>? {
        return stationName
    }

    fun afterUserNameChange(s: CharSequence) {
        this.stationName.apply { s }
    }

}

