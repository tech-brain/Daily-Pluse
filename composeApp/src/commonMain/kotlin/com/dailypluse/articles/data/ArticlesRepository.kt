package com.dailypluse.articles.data

import com.dailypluse.articles.data.ArticlesService

class ArticlesRepository(private val dataSource: ArticlesDataSource,
                         private val articlesService: ArticlesService
) {

    suspend fun getArticles(forceFetch : Boolean) : List<ArticlesResponse.Article>{
        if(forceFetch){
            dataSource.clearArticles()
            return fetchArticles()
        }
        val articlesDb = dataSource.getAllArticles()

        println("database_result ${articlesDb.size}")
        if(articlesDb.isEmpty()){
                return fetchArticles()
        }

        return articlesDb
    }

    private suspend fun fetchArticles() : List<ArticlesResponse.Article>{
        val fetchedArtciles = articlesService.fetchArticles()
        dataSource.insertArticles(fetchedArtciles)
        return fetchedArtciles
    }

}