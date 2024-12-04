package com.songjang.carmanagement.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NaverGeocodingClient {
    private const val BASE_URL = "https://naveropenapi.apigw.ntruss.com/"

    val api: NaverGeocodingApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NaverGeocodingApi::class.java)
    }
}