package com.example.weatherapp.Domain.API

import com.example.weatherapp.Data.WeatherResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    @GET("/v1/current.json")

    suspend fun getWeather(
        @Query("key") key : String = API_KEY,
        @Query("q") location : String
    ) : Response<WeatherResponseModel>


}