package com.example.cocktailbar.entities.response

import com.google.gson.annotations.SerializedName


data class DrinkListResponse(
    @SerializedName("drinks")
    var drinks: ArrayList<DrinkResponse> = arrayListOf()
)