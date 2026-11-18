package com.apps.bookshelf.data

import com.apps.bookshelf.BuildConfig
import com.apps.bookshelf.data.model.BookDetails
import com.apps.bookshelf.data.remote.BooksApiService
import java.io.IOException

class NetworkBooksRepository(
    private val booksApiService: BooksApiService
) : BooksRepository {

    override suspend fun getBooks(query: String): List<BookDetails> {

        // Obtener la API Key desde BuildConfig
        val apiKey = BuildConfig.BOOKS_API_KEY

        // Realizar la búsqueda en Google Books
        val response = booksApiService.searchBooks(query, apiKey)

        // Comprobar si la respuesta fue exitosa
        if (!response.isSuccessful) {
            val errorBody = response.errorBody()?.string()

            throw IOException(
                "Error HTTP ${response.code()}: $errorBody"
            )
        }

        // Obtener los resultados de la respuesta
        val searchResponse = response.body()
            ?: throw IOException("La respuesta no contiene datos")

        // Convertir los resultados en una lista de BookDetails
        return searchResponse.items.map { item ->
            BookDetails(
                volumeInfo = item.volumeInfo
            )
        }
    }
}