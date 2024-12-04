package com.songjang.carmanagement.api

import com.songjang.carmanagement.models.GeocodingResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NaverGeocodingApi {
    @GET("map-geocode/v2/geocode")
    fun getGeocode(
        @Header("X-NCP-APIGW-API-KEY-ID") clientId: String,
        @Header("X-NCP-APIGW-API-KEY") clientSecret: String,
        @Query("query") query: String
    ): Call<GeocodingResponse>
}