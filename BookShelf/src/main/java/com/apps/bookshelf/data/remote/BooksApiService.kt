package com.apps.bookshelf.data.remote

import com.apps.bookshelf.data.model.BookDetails
import com.apps.bookshelf.data.model.BookSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BooksApiService {

    @GET("volumes")
    suspend fun searchBooks(
        @Query("q") query: String,
        @Query("key") apiKey: String
    ): Response<BookSearchResponse>

    @GET("volumes/{volumeId}")
    suspend fun getBookDetails(
        @Path("volumeId") volumeId: String
    ): BookDetails
}
