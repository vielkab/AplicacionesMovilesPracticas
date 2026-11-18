package com.apps.bookshelf.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.apps.bookshelf.data.BooksRepository

class BooksViewModelFactory(
    private val booksRepository: BooksRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        if (modelClass.isAssignableFrom(BooksViewModel::class.java)) {

            @Suppress("UNCHECKED_CAST")
            return BooksViewModel(booksRepository) as T
        }

        throw IllegalArgumentException(
            "ViewModel desconocido: ${modelClass.name}"
        )
    }
}
