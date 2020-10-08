package com.example.testapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.liveData
import com.example.testapp.model.repos.mars.MarsRepository

class MarsViewModel(private val marsRepository: MarsRepository, application: Application) :
    AndroidViewModel(application) {

    fun getMarsProperty() = liveData {
        emit(marsRepository.getMarsProperty())
    }
}