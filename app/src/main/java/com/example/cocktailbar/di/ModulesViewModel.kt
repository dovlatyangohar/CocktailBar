package com.example.cocktailbar.di

import com.example.cocktailbar.ui.MainViewModel
import com.example.cocktailbar.ui.fragment.randomdrink.RandomDrinkViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel {RandomDrinkViewModel(get())}
}