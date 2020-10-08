package com.example.testapp.model.network

import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiClient {
    private var retrofit: Retrofit? = null
    private val BASE_URL = "https://mars.udacity.com/"

    fun getRetrofitInstance(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }

    companion object {
        fun getInstance(): ApiInterface = ApiClient().getRetrofitInstance()!!
            .create(ApiInterface::class.java)

    }
}