package com.example.testapp.model.network

import com.example.testapp.model.pojo.mars_property.MarsProperty
import retrofit2.http.GET

interface ApiInterface {

    @GET("realestate")
    suspend fun getMarsProperties(): MarsProperty
}