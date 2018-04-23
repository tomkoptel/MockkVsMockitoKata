package com.tom.kata.mocks

import java.util.*

@MakeItOpen
data class Article(val id: String, val title: String, val description: String)

@MakeItOpen
data class Author(val uid: String, val name: String, val surname: String)

@MakeItOpen
data class Comment(val body: String, val createdAt: Date, val author: Author, val articleId: String)