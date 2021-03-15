package com.example.marsrealestate

import com.example.marsrealestate.dummy.RealEstateData
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://mars.udacity.com/"
private val retrofit : Retrofit = Retrofit.Builder().baseUrl(BASE_URL).
addConverterFactory(GsonConverterFactory.create()).build()

object RealEstateAPI {
    val retrofitService : RealEstateApiService by lazy {
        retrofit.create(RealEstateApiService::class.java)
    }
}

enum class RealEstateApiFilter(val value: String) { SHOW_RENT("rent"), SHOW_BUY("buy"), SHOW_ALL("all") }

interface RealEstateApiService {

    @GET("realestate")
   suspend fun getProperties(@Query("filter") type: String): List<RealEstateData>

}