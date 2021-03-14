package com.example.marsrealestate

import com.example.marsrealestate.dummy.RealEstateData
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.http.GET

private const val BASE_URL = "https://mars.udacity.com/"
private val retrofit : Retrofit = Retrofit.Builder().baseUrl(BASE_URL).
addConverterFactory(GsonConverterFactory.create()).build()

object RealEstateAPI {
    val retrofitService : RealEstateApiService by lazy {
        retrofit.create(RealEstateApiService::class.java)
    }
}

interface RealEstateApiService {

    @GET("realestate")
   suspend fun getProperties(): List<RealEstateData>

}