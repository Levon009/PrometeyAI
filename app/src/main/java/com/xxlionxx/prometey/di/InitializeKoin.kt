package com.xxlionxx.prometey.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initializeKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            databaseModule,
            networkModule,
            dataSourceModule,
            repositoryModule,
            useCaseModule,
            viewModelModule
        )
    }
}