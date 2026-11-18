package com.apps.bookshelf.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BooksApi {
    private const val BASE_URL =
        "https://www.googleapis.com/books/v1/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val retrofitService: BooksApiService by lazy {
        retrofit.create(BooksApiService::class.java)
    }
}