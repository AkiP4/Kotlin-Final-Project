package com.example.kotlin_application

import retrofit2.Call
import retrofit2.http.GET

interface ApiRequests {

    @GET("api/address/random_address")
    fun getAddress(): Call<Map<String, Object>>


}