package com.tom.kata.mocks

import java.util.*

class MainPresenter(
    private val articlesModel: ArticleDataModel,
    private val commentsModel: CommentDataModel,
    private val view: MainView,
    private val logger: Logger
) {
    fun loadPage() {
        articlesModel.load(Date()).map {
            ViewArticle(
                article = it,
                comments = commentsModel.load(it.id)
            )
        }.let {
            logger.log(it.joinToString())
            view.render(it)
        }
    }
}