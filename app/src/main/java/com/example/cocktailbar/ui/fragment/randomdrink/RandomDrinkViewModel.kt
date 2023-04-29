package com.example.cocktailbar.ui.fragment.randomdrink

import androidx.lifecycle.viewModelScope
import com.example.cocktailbar.base.viewmodel.BaseViewModel
import com.example.cocktailbar.core.ActionResult
import com.example.cocktailbar.domain.interactors.RandomDrinkUseCase
import com.example.cocktailbar.domain.model.DrinkListInfo
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class RandomDrinkViewModel(
    private val randomDrinkUseCase: RandomDrinkUseCase
) : BaseViewModel() {
    private val _randomDrinkSuccess: MutableSharedFlow<DrinkListInfo> by lazy { MutableSharedFlow() }
    val randomDrinkSuccess = _randomDrinkSuccess.asSharedFlow()

    private val _randomDrinkFailure: MutableSharedFlow<String> by lazy { MutableSharedFlow() }
    val randomDrinkFailure = _randomDrinkFailure.asSharedFlow()

    private fun getRandomDrink(){
        viewModelScope.launch {
            when (val result = callData(
               randomDrinkUseCase()
                )
            ){
                is ActionResult.Success -> {
                    _randomDrinkSuccess.emit(result.data)
                }
                is ActionResult.Error -> {
                    _randomDrinkFailure.emit("SOMETHING WENT WRONG")
                }
            }
        }
    }

}