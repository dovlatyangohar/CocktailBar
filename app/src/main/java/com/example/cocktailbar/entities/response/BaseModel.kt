package com.example.cocktailbar.entities.response

import com.google.gson.annotations.SerializedName

data class BaseModel<T>(
    @SerializedName("data")
    val data: T? = null,
    @SerializedName("error")
    val error: Boolean? = null,
    @SerializedName("message")
    val message: String? = null
)