package com.apps.bookshelf.data.model

data class BookSearchResponse(
    val items: List<BookSearchItem> = emptyList()
)

data class BookSearchItem(
    val id: String = "",
    val volumeInfo: VolumeInfo? = null
)

data class BookDetails(
    val volumeInfo: VolumeInfo? = null
)

data class VolumeInfo(
    val title: String? = null,
    val imageLinks: ImageLinks? = null
)

data class ImageLinks(
    val thumbnail: String? = null
)