
package com.apps.bookshelf.fake

import com.apps.bookshelf.data.model.BookDetails
import com.apps.bookshelf.data.model.BookSearchResponse
import com.apps.bookshelf.data.remote.BooksApiService
import retrofit2.Response

class FakeBooksApiService(
    private val response: Response<BookSearchResponse>
) : BooksApiService {

    override suspend fun searchBooks(
        query: String,
        apiKey: String
    ): Response<BookSearchResponse> {
        return response
    }

    override suspend fun getBookDetails(
        volumeId: String
    ): BookDetails {
        throw UnsupportedOperationException(
            "Esta función no se utiliza en esta prueba"
        )
    }
}
