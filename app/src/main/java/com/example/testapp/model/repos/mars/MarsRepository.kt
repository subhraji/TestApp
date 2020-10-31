package com.example.testapp.model.repos.mars

import com.example.testapp.model.pojo.mars_property.MarsProperty
import com.example.testapp.model.repos.Outcome

interface MarsRepository{
    suspend fun getMarsProperty(): Outcome<List<MarsProperty>>
}