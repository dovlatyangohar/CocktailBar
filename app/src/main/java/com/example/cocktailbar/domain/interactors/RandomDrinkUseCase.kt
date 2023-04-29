package com.example.cocktailbar.domain.interactors

import com.example.cocktailbar.core.ActionResult
import com.example.cocktailbar.domain.model.DrinkListInfo

interface RandomDrinkUseCase {
    suspend operator fun invoke(): ActionResult<DrinkListInfo>
}