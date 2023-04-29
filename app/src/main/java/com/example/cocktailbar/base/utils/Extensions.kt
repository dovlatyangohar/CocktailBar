package com.example.cocktailbar.base.utils

import androidx.lifecycle.LifecycleOwner
import com.example.cocktailbar.base.viewmodel.FlowObserver
import kotlinx.coroutines.flow.Flow

inline fun <reified T> Flow<T>.observeInLifecycle(
    lifecycleOwner: LifecycleOwner
) = FlowObserver(lifecycleOwner, this)