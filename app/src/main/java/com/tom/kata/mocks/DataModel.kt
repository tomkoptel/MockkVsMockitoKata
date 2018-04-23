package com.tom.kata.mocks

import java.util.*

class ArticleDataModel {
    fun load(date: Date): List<Article> {
        return listOf()
    }
}

class CommentDataModel {
    fun load(articleId: String): List<Comment> {
        return listOf()
    }
}