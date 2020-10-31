package com.example.testapp

import com.example.testapp.model.repos.mars.MarsRepository
import com.example.testapp.model.repos.mars.MarsRepositoryImpl
import com.example.testapp.viewmodel.MarsViewModel
import org.koin.dsl.module
import org.koin.android.viewmodel.dsl.viewModel

val appModule = module {

    single<MarsRepository> { MarsRepositoryImpl()}
    viewModel { MarsViewModel(get(), get()) }
}