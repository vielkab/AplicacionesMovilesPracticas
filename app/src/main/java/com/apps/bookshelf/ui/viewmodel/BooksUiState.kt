package com.apps.bookshelf.ui.viewmodel

import com.apps.bookshelf.data.model.BookDetails

sealed interface BooksUiState {
    data object Loading : BooksUiState

    data class Success(
        val books: List<BookDetails>
    ) : BooksUiState

    data object Error : BooksUiState
}