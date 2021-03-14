package com.example.marsrealestate

import androidx.lifecycle.*
import com.example.marsrealestate.dummy.RealEstateData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.IllegalArgumentException


class OverviewViewModel : ViewModel() {

    private val _response = MediatorLiveData<List<RealEstateData>>()
    val response: LiveData<List<RealEstateData>>
        get() = _response

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    init{
        RealEstateAPI.retrofitService.getProperties().enqueue( object: Callback<List<RealEstateData>> {
            override fun onFailure(call: Call<List<RealEstateData>>, t: Throwable) {
                throw IllegalArgumentException("No Data Found")
            }

            override fun onResponse(call: Call<List<RealEstateData>>, response: Response<List<RealEstateData>>) {
                _response.value = response.body()
            }
        })
    }

}