package com.example.practicacalificada4pm.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {
    private val URL_BASE = "https://pokeapi.co/"

    val apiService = Retrofit.Builder()
        .baseUrl(URL_BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(TecsupApi::class.java)
}