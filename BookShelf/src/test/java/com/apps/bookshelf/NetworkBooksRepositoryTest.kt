package com.apps.bookshelf

import com.apps.bookshelf.data.NetworkBooksRepository
import com.apps.bookshelf.data.model.BookSearchItem
import com.apps.bookshelf.data.model.BookSearchResponse
import com.apps.bookshelf.fake.FakeBooksApiService
import com.apps.bookshelf.fake.FakeDataSource
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import retrofit2.Response

class NetworkBooksRepositoryTest {

    @Test
    fun getBooks_returnsBooksFromApiResponse() = runTest {

        // Preparar una respuesta simulada utilizando los datos falsos
        val fakeResponse = BookSearchResponse(
            items = FakeDataSource.books.mapIndexed { index, book ->
                BookSearchItem(
                    id = "book${index + 1}",
                    volumeInfo = book.volumeInfo
                )
            }
        )

        // Crear el servicio falso
        val fakeApiService = FakeBooksApiService(
            response = Response.success(fakeResponse)
        )

        // Crear el repositorio con el servicio falso
        val repository = NetworkBooksRepository(fakeApiService)

        // Ejecutar la búsqueda
        val books = repository.getBooks("jazz history")

        // Comprobar que el resultado coincide con los datos simulados
        assertEquals(FakeDataSource.books, books)
    }
}
