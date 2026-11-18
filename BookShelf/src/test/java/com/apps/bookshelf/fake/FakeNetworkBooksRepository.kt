
package com.apps.bookshelf.fake

import com.apps.bookshelf.data.BooksRepository
import com.apps.bookshelf.data.model.BookDetails

class FakeNetworkBooksRepository : BooksRepository {

    override suspend fun getBooks(query: String): List<BookDetails> {
        return FakeDataSource.books
    }
}
