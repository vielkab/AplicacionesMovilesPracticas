package com.apps.bookshelf

import com.apps.bookshelf.data.model.BookDetails
import com.apps.bookshelf.fake.FakeNetworkBooksRepository
import com.apps.bookshelf.fake.FakeDataSource
import com.apps.bookshelf.rules.TestDispatcherRule
import com.apps.bookshelf.ui.viewmodel.BooksUiState
import com.apps.bookshelf.ui.viewmodel.BooksViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class BooksViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun booksViewModel_getBooks_verifyBooksUiStateSuccess() = runTest {

        // Crear el ViewModel con el repositorio falso
        val viewModel = BooksViewModel(
            booksRepository = FakeNetworkBooksRepository()
        )

        // Obtener el estado actual del ViewModel
        val uiState = viewModel.uiState.value

        // Comprobar que el estado sea Success y contenga los libros esperados
        assertEquals(
            BooksUiState.Success(FakeDataSource.books),
            uiState
        )
    }
}
