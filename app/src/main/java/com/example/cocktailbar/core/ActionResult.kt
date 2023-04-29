package com.example.cocktailbar.core

sealed class ActionResult<out S> {
    data class Success<S>(val data: S) : ActionResult<S>()
    data class Error(val errors: Throwable) : ActionResult<Nothing>()
}