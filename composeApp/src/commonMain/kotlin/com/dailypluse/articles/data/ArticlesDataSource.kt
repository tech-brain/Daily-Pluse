package com.dailypluse.articles.data

import com.dailypluse.articles.data.ArticlesResponse
import com.dailypluse.db.DailyPluseDatabase

class ArticlesDataSource(private val database : DailyPluseDatabase) {

    fun getAllArticles() : List<ArticlesResponse.Article>
    = database.dailyPluseDatabaseQueries.selectAllArticles(::mapToArticle).executeAsList()


    fun insertArticles(articles: List<ArticlesResponse.Article>){
        database.dailyPluseDatabaseQueries.transaction{
            articles.forEach { article ->
                insertArticle(article)
            }

        }
    }

    fun clearArticles() = database.dailyPluseDatabaseQueries.removeAllArticles()

    private fun insertArticle(article: ArticlesResponse.Article) {
        database.dailyPluseDatabaseQueries.insertArticle(
            article.title,
            article.description,
            article.publishedAt,
            article.urlToImage
        )
    }

    private fun mapToArticle(
        title: String,
        desc: String?,
        date: String,
        url: String?
    ): ArticlesResponse.Article =
        ArticlesResponse.Article(
            desc,
            date,
            title,
            url
        )
}