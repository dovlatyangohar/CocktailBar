package com.example.cocktailbar.di

import com.arplusplus.core.dispatcher.CoroutineDispatcherProvider
import com.example.cocktailbar.core.dispatcher.BaseCoroutineDispatcherProvider
import com.example.cocktailbar.domain.interactors.RandomDrinkUseCase
import com.example.cocktailbar.domain.usecases.RandomDrinkUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<CoroutineDispatcherProvider> { BaseCoroutineDispatcherProvider() }
    factory<RandomDrinkUseCase> { RandomDrinkUseCaseImpl(get(), get()) }
}