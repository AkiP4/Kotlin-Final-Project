package com.example.kotlin_application

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class AddressDataViewModel: ViewModel() {
    val country = mutableStateOf("")

    val api =
        Retrofit
        .Builder()
        .baseUrl("https://random-data-api.com/")
        .addConverterFactory( GsonConverterFactory.create() )
        .build()
        .create<ApiRequests>()

    fun getRandomCityData() {
        viewModelScope.launch {
            val resp = api.getAddress().awaitResponse()
            if(resp.isSuccessful){
                val map = resp.body()
                country.value = map!!["country"].toString()
            }else{
                Log.d("***", "not successful")
            }


        }
    }
}