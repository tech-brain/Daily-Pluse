package com.dailypluse.di

import com.dailypluse.articles.presentation.ArticlesViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin() {

    val module = sharedKoinModules + databaseModule
    startKoin {
        modules(module)
    }

}

class ArticlesInjector : KoinComponent{
    val articlesViewModel : ArticlesViewModel by inject()
}