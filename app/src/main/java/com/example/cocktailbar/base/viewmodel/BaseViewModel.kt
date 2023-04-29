package com.example.cocktailbar.base.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailbar.core.ActionResult
import com.example.cocktailbar.core.CallException
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import java.io.IOException

abstract class BaseViewModel : ViewModel() {

    private val _showDefaultError = MutableSharedFlow<String?>()
    val showDefaultError = _showDefaultError.asSharedFlow()
    private val _showNetworkError: MutableSharedFlow<() -> Unit> by lazy { MutableSharedFlow() }
    val showNetworkError = _showNetworkError.asSharedFlow()

    fun <T> callData(
        result: ActionResult<T>, callback: () -> Unit = {}
    ): ActionResult<T> {
        return when (result) {
            is ActionResult.Success -> {
                result
            }
            is ActionResult.Error -> {
                viewModelScope.launch {
                    when (result.errors) {
                        is IOException -> {
                            _showNetworkError.emit {
                                callback()
                            }

                        }
                        else -> {
                            _showDefaultError.emit((result.errors as? CallException)?.errorMessage)
                        }
                    }
                }
                ActionResult.Error(result.errors)
            }
        }
    }

}