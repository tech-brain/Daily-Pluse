package com.dailypluse.articles.presentation

import com.dailypluse.BaseViewModel
import com.dailypluse.articles.application.ArticlesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(
    private val useCase : ArticlesUseCase
) : BaseViewModel() {

    private val _articleState : MutableStateFlow<ArticleState> = MutableStateFlow(
        ArticleState(
            loading = true
        )
    )

    val articleState : StateFlow<ArticleState> get() = _articleState


    init {

        getArticles()
    }
  fun getArticles(forceFetch : Boolean=false){
      println("artiles_refreshing")
        scope.launch {

            _articleState.emit(
                ArticleState(
                    loading = true,
                    articles = _articleState.value.articles
                )
            )


            val fetchedArticles = useCase.getArticles(forceFetch)

            _articleState.emit(ArticleState(articles = fetchedArticles))
        }
    }





}