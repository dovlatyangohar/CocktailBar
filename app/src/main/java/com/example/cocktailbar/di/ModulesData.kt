package com.example.cocktailbar.di

import com.example.cocktailbar.core.Constants.Companion.BASE_URL
import com.example.cocktailbar.data.apiservice.ApiService
import com.example.cocktailbar.data.repository.DrinksRepositoryImpl
import com.example.cocktailbar.domain.repository.DrinksRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single<ApiService> { get<Retrofit>().create(ApiService::class.java) }
}

val repositoryModule = module {
    single<DrinksRepository> { DrinksRepositoryImpl(get()) }
}