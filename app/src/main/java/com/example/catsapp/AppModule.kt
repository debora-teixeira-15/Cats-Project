package com.example.catsapp

import com.example.catsapp.CatsList.CatsListViewModel
import com.example.catsapp.data.CatsApi
import com.example.catsapp.data.repository.CatsRepository
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single<CatsApi> { provideCatsApi() }
    single<CatsRepository> { CatsRepository(get()) }
    viewModel<CatsListViewModel> { CatsListViewModel(get()) }
}

private fun provideCatsApi(): CatsApi {
    return Retrofit.Builder()
        .baseUrl("https://api.thecatapi.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())  // Gson converter
        .build()
        .create(CatsApi::class.java)
}