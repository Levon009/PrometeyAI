package com.xxlionxx.prometey.di

import com.xxlionxx.prometey.data.remote.datasource.ForecastDataSource
import com.xxlionxx.prometey.data.remote.datasource.ForecastDataSourceImpl
import com.xxlionxx.prometey.data.remote.datasource.OpenAIDataSource
import com.xxlionxx.prometey.data.remote.datasource.OpenAIDataSourceImpl
import com.xxlionxx.prometey.data.remote.datasource.GeminiDataSource
import com.xxlionxx.prometey.data.remote.datasource.GeminiDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {

    single<OpenAIDataSource> {
        OpenAIDataSourceImpl(
            api = get()
        )
    }

    single<GeminiDataSource> {
        GeminiDataSourceImpl(
            api = get()
        )
    }

    single<ForecastDataSource> {
        ForecastDataSourceImpl()
    }
}