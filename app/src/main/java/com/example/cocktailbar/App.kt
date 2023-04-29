package com.example.cocktailbar

import android.app.Application
import com.example.cocktailbar.di.apiModule
import com.example.cocktailbar.di.repositoryModule
import com.example.cocktailbar.di.useCaseModule
import com.example.cocktailbar.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            modules(modules)
        }
    }

    private val modules = listOf(
        apiModule,
        repositoryModule,
        useCaseModule,
        viewModelModule
    )
}