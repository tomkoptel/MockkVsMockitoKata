package com.tom.kata.mocks

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class MainPresenterMockkTest {
    val article1Id = "article_1"
    val article1 = mockk<Article>(name = "Article 1").apply {
        every { id } returns article1Id
    }

    val article2Id = "article_2"
    val article2 = mockk<Article>(name = "Article 2").apply {
        every { id } returns article2Id
    }
    val articleDataModel = mockk<ArticleDataModel>().apply {
        every { load(any()) } returns listOf(article1, article2)
    }

    val comment1 = mockk<Comment>(name = "Comment 1")
    val comment2 = mockk<Comment>(name = "Comment 2")
    val commentDataModel = mockk<CommentDataModel>().apply {
        every { load(article1Id) } returns listOf(comment1)
        every { load(article2Id) } returns listOf(comment2)
    }

    val view = mockk<MainView>(relaxed = true)
    val modelUnderTest = MainPresenter(articleDataModel, commentDataModel, view)

    @Test
    fun test_load_page() {
        modelUnderTest.loadPage()

        verify { articleDataModel.load(any()) }
        verify { commentDataModel.load(article1Id) }
        verify { commentDataModel.load(article2Id) }
    }
}