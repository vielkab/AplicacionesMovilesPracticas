package com.apps.bookshelf

import android.app.Application
import com.apps.bookshelf.data.AppContainer
import com.apps.bookshelf.data.DefaultAppContainer

class BookShelfApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}