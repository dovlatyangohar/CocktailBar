package com.example.cocktailbar.domain.usecases

import com.arplusplus.core.dispatcher.CoroutineDispatcherProvider
import com.example.cocktailbar.core.ActionResult
import com.example.cocktailbar.domain.interactors.RandomDrinkUseCase
import com.example.cocktailbar.domain.model.DrinkListInfo
import com.example.cocktailbar.domain.repository.DrinksRepository
import kotlinx.coroutines.withContext

class RandomDrinkUseCaseImpl(
    private val dispatcher: CoroutineDispatcherProvider,
    private val repository: DrinksRepository
) : RandomDrinkUseCase {
    override suspend fun invoke(): ActionResult<DrinkListInfo> =
        withContext(dispatcher.io) {
            when (val result = repository.randomDrink(
            )) {
                is ActionResult.Success -> {
                    ActionResult.Success(DrinkListInfo.from(result.data))

                }
                is ActionResult.Error -> {
                    ActionResult.Error(result.errors)
                }
            }
        }
}