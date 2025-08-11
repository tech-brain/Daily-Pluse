package com.dailypluse.articles.application

import com.dailypluse.articles.data.ArticlesRepository
import com.dailypluse.articles.data.ArticlesResponse
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

class ArticlesUseCase(private val repository: ArticlesRepository) {
    suspend fun getArticles(boolean: Boolean): List<Article>{
        val articlesRaw = repository.getArticles(boolean)
        return mapArticles(articlesRaw)
    }

    private fun mapArticles(articlesRaw: List<ArticlesResponse.Article>): List<Article> = articlesRaw.map { article ->
        Article(
            article.title,
            article.description ?: "",
            getDaysAgoString(article.publishedAt),
            article.urlToImage ?: "https://placehold.co/600x400"
        )
    }

    @OptIn(ExperimentalTime::class)
    private fun getDaysAgoString(date : String) : String{
        val today = Clock.System.todayIn(TimeZone.Companion.currentSystemDefault())
        val days = today.daysUntil(
            Instant.Companion.parse(date).toLocalDateTime(TimeZone.Companion.currentSystemDefault()).date
        )

        val result = when{
            abs(days) > 1 -> "${abs(days)} days ago"
            abs(days) ==  1 -> "Yesterday"
            else -> "Today"
        }

        return result
    }

}