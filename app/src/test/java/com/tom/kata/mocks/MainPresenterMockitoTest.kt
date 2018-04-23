package com.tom.kata.mocks

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test

class MainPresenterMockitoTest {
    val article1Id = "article_1"
    val article1 = mock<Article>(name = "Article 1") {
        on { id } doReturn article1Id
    }

    val article2Id = "article_2"
    val article2 = mock<Article>(name = "Article 2") {
        on { id } doReturn article2Id
    }
    val articleDataModel = mock<ArticleDataModel>() {
        on { load(any()) } doReturn listOf(article1, article2)
    }

    val comment1 = mock<Comment>(name = "Comment 1")
    val comment2 = mock<Comment>(name = "Comment 2")
    val commentDataModel = mock<CommentDataModel>() {
        on { load(article1Id) } doReturn listOf(comment1)
        on { load(article2Id) } doReturn listOf(comment2)
    }

    val view = mock<MainView>()
    val logger = mock<Logger>()
    val modelUnderTest =         MainPresenter(articleDataModel, commentDataModel, view, logger)

    @Test
    fun test_load_page() {
        modelUnderTest.loadPage()

        verify(articleDataModel).load(any())
        verify(commentDataModel).load(article1Id)
        verify(commentDataModel).load(article2Id)
    }
}