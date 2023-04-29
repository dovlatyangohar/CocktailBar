package com.example.cocktailbar.domain.repository

import com.example.cocktailbar.entities.response.DrinkListResponse
import com.example.cocktailbar.core.ActionResult

interface DrinksRepository {
    suspend fun randomDrink(): ActionResult<DrinkListResponse>
}