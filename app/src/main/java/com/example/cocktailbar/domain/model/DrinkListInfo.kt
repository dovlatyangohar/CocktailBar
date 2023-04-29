package com.example.cocktailbar.domain.model

import com.example.cocktailbar.entities.response.DrinkListResponse

data class DrinkListInfo(
    val drinks: List<DrinkInfo>
) {
    companion object {
        fun from(data: DrinkListResponse): DrinkListInfo =
            with(data){
                DrinkListInfo(
                    drinks = drinks.map { item ->
                        item.let { DrinkInfo.from(it) }
                    }
                )
            }
    }
}
