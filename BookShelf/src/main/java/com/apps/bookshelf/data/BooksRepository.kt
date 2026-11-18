package com.apps.bookshelf.data

import com.apps.bookshelf.data.model.BookDetails

interface BooksRepository {

    suspend fun getBooks(query: String): List<BookDetails>
}