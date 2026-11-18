package com.apps.bookshelf.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apps.bookshelf.data.BooksRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import android.util.Log

class BooksViewModel(
    private val booksRepository: BooksRepository
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<BooksUiState>(BooksUiState.Loading)

    val uiState: StateFlow<BooksUiState> =
        _uiState.asStateFlow()

    init {
        getBooks()
    }

    fun getBooks() {
        viewModelScope.launch {
            _uiState.value = BooksUiState.Loading

            try {
                val books = booksRepository.getBooks("jazz history")
                _uiState.value = BooksUiState.Success(books)

            } catch (exception: CancellationException) {
                throw exception
            } catch (exception: Exception) {
                Log.e("BooksViewModel", "Error al cargar los libros", exception)
                _uiState.value = BooksUiState.Error
            }
        }
    }
}
