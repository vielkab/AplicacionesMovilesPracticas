package com.apps.bookshelf.fake

import com.apps.bookshelf.data.model.BookDetails
import com.apps.bookshelf.data.model.VolumeInfo

object FakeDataSource {

    val books = listOf(
        BookDetails(
            volumeInfo = VolumeInfo(
                title = "Jazz History"
            )
        ),
        BookDetails(
            volumeInfo = VolumeInfo(
                title = "The History of Jazz"
            )
        )
    )
}
