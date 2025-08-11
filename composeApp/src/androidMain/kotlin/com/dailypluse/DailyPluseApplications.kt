package com.dailypluse

import android.app.Application
import com.dailypluse.di.databaseModule
import com.dailypluse.di.sharedKoinModules
import com.dailypluse.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DailyPluseApplications : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModules + viewModelsModule + databaseModule
        startKoin {
            androidContext(this@DailyPluseApplications)
            modules(modules)
        }
    }
}