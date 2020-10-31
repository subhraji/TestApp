package com.example.testapp.model.repos.mars

import androidx.lifecycle.MutableLiveData
import com.example.testapp.model.network.ApiClient
import com.example.testapp.model.pojo.mars_property.MarsProperty
import com.example.testapp.model.repos.Outcome

class MarsRepositoryImpl : MarsRepository {

    private val apiService = ApiClient.getInstance()

    override suspend fun getMarsProperty(): Outcome<List<MarsProperty>> {
        val apiResponse = MutableLiveData<Outcome<List<MarsProperty>>>()
        try {
            val response = apiService.getMarsProperties()
            apiResponse.value = Outcome.success(response)
        } catch (e: Throwable) {
            apiResponse.value = Outcome.failure(e)
        }

        return apiResponse.value as Outcome<List<MarsProperty>>
    }

}