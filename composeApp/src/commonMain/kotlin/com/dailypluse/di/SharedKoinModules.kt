package com.dailypluse.di

import com.dailypluse.articles.di.articleModule

val sharedKoinModules = listOf(
    articleModule,
    networkModule
)