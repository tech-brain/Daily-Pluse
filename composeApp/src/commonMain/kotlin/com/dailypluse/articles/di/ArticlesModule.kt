package com.dailypluse.articles.di

import com.dailypluse.articles.data.ArticlesDataSource
import com.dailypluse.articles.data.ArticlesRepository
import com.dailypluse.articles.data.ArticlesService
import com.dailypluse.articles.application.ArticlesUseCase
import com.dailypluse.articles.presentation.ArticlesViewModel
import org.koin.dsl.module

val articleModule = module{

    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }

}