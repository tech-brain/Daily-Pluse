package com.dailypluse.di

import app.cash.sqldelight.db.SqlDriver
import com.dailypluse.db.DailyPluseDatabase
import com.dailypluse.db.DatabaseDriverFactory
import org.koin.dsl.module

val databaseModule = module {

    single<SqlDriver> { DatabaseDriverFactory().createDriver() }

    single<DailyPluseDatabase> { DailyPluseDatabase(get()) }
}