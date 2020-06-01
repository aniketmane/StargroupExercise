package com.example.stargroupexercise.data.api

import com.example.stargroupexercise.data.model.ArrayOfObjStationData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface StationApiService {
    @GET("realtime.asmx/getStationDataByNameXML?")
    suspend fun getTrainsByStationNames(@Query("StationDesc") query: String, @Query("NumMins") numMins:Int): ArrayOfObjStationData

    @GET("realtime.asmx/getStationDataByNameXML?")
     fun getTrainsByStation(@Query("StationDesc") query: String): Call<ArrayOfObjStationData>
}