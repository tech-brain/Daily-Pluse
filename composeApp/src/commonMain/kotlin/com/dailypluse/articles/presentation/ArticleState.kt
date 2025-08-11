package com.dailypluse.articles.presentation

import com.dailypluse.articles.application.Article

data class ArticleState (
    val articles : List<Article> = listOf(),
    val loading : Boolean = false,
    val error : String? = null
)