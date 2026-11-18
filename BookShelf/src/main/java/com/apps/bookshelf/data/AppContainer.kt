package com.apps.bookshelf.data

import com.apps.bookshelf.data.remote.BooksApi

interface AppContainer {
    val booksRepository: BooksRepository
}

class DefaultAppContainer : AppContainer {

    override val booksRepository: BooksRepository by lazy {
        NetworkBooksRepository(BooksApi.retrofitService)
    }
}