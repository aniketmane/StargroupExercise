package com.example.stargroupexercise.data.api

import okhttp3.OkHttpClient
import org.simpleframework.xml.convert.AnnotationStrategy
import org.simpleframework.xml.core.Persister
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory.createNonStrict

object NetworkBuilder {

    private const val BASE_URL = "http://api.irishrail.ie/realtime/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient())
            .addConverterFactory(
                createNonStrict(
                    Persister(
                        AnnotationStrategy() // important part!
                    )
                )
            )
            .build()
    }

    val apiService: StationApiService = getRetrofit().create(StationApiService::class.java)


}