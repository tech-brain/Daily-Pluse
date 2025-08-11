package com.dailypluse.articles.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticlesResponse(
    @SerialName("articles")
    val articles: List<Article>,
    @SerialName("status")
    val status: String,
    @SerialName("totalResults")
    val totalResults: Int
) {
    @Serializable
    data class Article(
        @SerialName("description")
        val description: String?,
        @SerialName("publishedAt")
        val publishedAt: String,
        @SerialName("title")
        val title: String,
        @SerialName("urlToImage")
        val urlToImage: String?
    )
}