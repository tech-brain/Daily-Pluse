package com.dailypluse.di

import com.dailypluse.articles.presentation.ArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel { ArticlesViewModel(get()) }

}