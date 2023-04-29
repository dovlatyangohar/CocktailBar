package com.example.cocktailbar.core

data class CallException(
    val errorCode: Int,
    val errorMessage: String? = null,
    val errorBody: ErrorBody? = null
) : Exception()
