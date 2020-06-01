package com.example.stargroupexercise.data.repository

import com.example.stargroupexercise.data.model.ArrayOfObjStationData
import kotlinx.coroutines.flow.Flow


interface StationApiRepository {
    fun getTrainsByStationName(stationName: String, numMins: Int): Flow<ArrayOfObjStationData>
}