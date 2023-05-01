package com.example.cocktailbar.data.apiservice


import com.example.cocktailbar.entities.response.DrinkListResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("random.php")
    suspend fun randomDrinks(): Response<DrinkListResponse>
}