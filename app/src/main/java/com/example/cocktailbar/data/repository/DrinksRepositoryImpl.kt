package com.example.cocktailbar.data.repository

import com.example.cocktailbar.core.ActionResult
import com.example.cocktailbar.data.apiservice.ApiService
import com.example.cocktailbar.data.util.analyzeResponse
import com.example.cocktailbar.data.util.makeApiCall
import com.example.cocktailbar.domain.repository.DrinksRepository
import com.example.cocktailbar.entities.response.DrinkListResponse

class DrinksRepositoryImpl(private val apiService: ApiService): DrinksRepository {
    override suspend fun randomDrink(): ActionResult<DrinkListResponse>  = makeApiCall {
        analyzeResponse(apiService.randomDrinks())
    }
}