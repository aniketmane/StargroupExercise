package com.example.stargroupexercise.data.repository

import com.example.stargroupexercise.data.api.StationApiService
import com.example.stargroupexercise.data.model.ArrayOfObjStationData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class StationApiRepositoryImpl(private val apiService: StationApiService) :
    StationApiRepository {

    override fun getTrainsByStationName(
        stationName: String,
        numMins: Int
    ): Flow<ArrayOfObjStationData> =
        flow { emit(apiService.getTrainsByStationNames(stationName, numMins)) }

}