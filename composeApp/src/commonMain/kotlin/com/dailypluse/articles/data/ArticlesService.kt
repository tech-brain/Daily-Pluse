package com.dailypluse.articles.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService(private val httpClient: HttpClient) {

    private val country = "us"
    private val category = "business"
    private val apiKey = "8b07f123c81f4921a034c3aa4615c0f5"

    suspend fun fetchArticles(): List<ArticlesResponse.Article>{
        val response : ArticlesResponse = httpClient.get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey").body()
       return response.articles
    }
}