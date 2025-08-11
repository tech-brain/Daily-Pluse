package com.dailypluse.di

import app.cash.sqldelight.db.SqlDriver
import com.dailypluse.db.DailyPluseDatabase
import com.dailypluse.db.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }

    single<DailyPluseDatabase> { DailyPluseDatabase(get()) }
}