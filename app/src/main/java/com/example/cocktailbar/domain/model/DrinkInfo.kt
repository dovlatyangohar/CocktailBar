package com.example.cocktailbar.domain.model

import com.example.cocktailbar.core.DiffUtilModel
import com.example.cocktailbar.entities.response.DrinkResponse

data class DrinkInfo(
    override val id: String,
    val drinkName: String,
    val drinkCategory: String,
    val drinkAlcoholic: String,
    val drinkImg: String
) : DiffUtilModel<String>() {
    companion object {
        fun from(data: DrinkResponse): DrinkInfo =
            with(data) {
                DrinkInfo(
                    id = idDrink ?: "",
                    drinkName = strDrink ?: "",
                    drinkCategory = strCategory ?: "",
                    drinkAlcoholic = strAlcoholic ?: "",
                    drinkImg = strDrinkThumb ?: ""
                )
            }

        fun emptyItem() = DrinkInfo("", "", "", "", "")
    }
}
