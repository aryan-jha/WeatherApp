package com.example.weatherapp.Domain.ViewModel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.Data.WeatherResponseModel
import com.example.weatherapp.Domain.API.NetworkResponse
import com.example.weatherapp.Domain.API.RetrofitInstance
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {


    private val weatherapi = RetrofitInstance.weatherAPI
    private val _weatherResult = MutableLiveData<NetworkResponse<WeatherResponseModel>>()
    val weatherResult : LiveData<NetworkResponse<WeatherResponseModel>> = _weatherResult

    fun getPlace(place:String){
        _weatherResult.value = NetworkResponse.Loading
        viewModelScope.launch {
            try {
                val result = weatherapi.getWeather(location = place)

                if(result.isSuccessful){
                    result.body()?.let {
                        _weatherResult.value = NetworkResponse.Success(it)
                    }
                }else{
                    _weatherResult.value = NetworkResponse.Error("Couldn't find the location")
                }
            }catch (e : Exception){
                _weatherResult.value = NetworkResponse.Error(e.message.toString())
            }
        }


    }



}