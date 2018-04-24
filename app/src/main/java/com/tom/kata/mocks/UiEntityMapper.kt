package com.tom.kata.mocks

object UiEntityMapper {
    fun fromTo(pair: Pair<Article, List<Comment>>) : ViewArticle {
        val (article, comments) = pair
        return ViewArticle(article = article, comments = comments)
    }
}