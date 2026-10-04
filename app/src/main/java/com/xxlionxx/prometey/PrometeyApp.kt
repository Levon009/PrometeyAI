package com.xxlionxx.prometey

import android.app.Application
import com.xxlionxx.prometey.data.local.AIModelInitializer
import com.xxlionxx.prometey.di.initializeKoin
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext

class PrometeyApp : Application() {

    private val aiModelInitializer: AIModelInitializer by inject()

    override fun onCreate() {
        super.onCreate()

        initializeKoin {
            androidContext(this@PrometeyApp)
        }

        CoroutineScope(Dispatchers.IO).launch {
            aiModelInitializer.initialize()
        }
    }
}