package com.example.cocktailbar.core.dispatcher

import com.arplusplus.core.dispatcher.CoroutineDispatcherProvider
import kotlinx.coroutines.Dispatchers

class BaseCoroutineDispatcherProvider : CoroutineDispatcherProvider {
    override val main by lazy { Dispatchers.Main }
    override val io by lazy { Dispatchers.IO }
}