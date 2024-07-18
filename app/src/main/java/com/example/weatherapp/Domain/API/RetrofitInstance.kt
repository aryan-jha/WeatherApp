package com.example.weatherapp.Domain.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    val weatherAPI : WeatherAPI = getRetrofitInstance().create(WeatherAPI::class.java)

}

