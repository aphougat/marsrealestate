package com.example.marsrealestate

import androidx.lifecycle.*
import com.example.marsrealestate.dummy.RealEstateData
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import java.lang.IllegalArgumentException

enum class Status{LOADING, DONE, ERROR
}
class OverviewViewModel : ViewModel() {

    private val _response = MediatorLiveData<List<RealEstateData>>()
    val response: LiveData<List<RealEstateData>>
        get() = _response

    private val _status = MutableLiveData<Status>()
    val status : LiveData<Status>
    get() = _status

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    init{

        getMarsRealEstateProperties(RealEstateApiFilter.SHOW_ALL)
    }

    private fun getMarsRealEstateProperties(filter : RealEstateApiFilter){
        coroutineScope.launch {
            try {
                _status.value = Status.LOADING
                _response.value = RealEstateAPI.retrofitService.getProperties(filter.value)
                _status.value = Status.DONE
            }catch(e :Exception)
            {
                _status.value = Status.ERROR
            }
        }
    }

    fun updateFilter(filter: RealEstateApiFilter) {
        getMarsRealEstateProperties(filter)
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}