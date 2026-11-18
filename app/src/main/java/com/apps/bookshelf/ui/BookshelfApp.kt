package com.apps.bookshelf.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.apps.bookshelf.BookShelfApplication
import com.apps.bookshelf.ui.viewmodel.BooksViewModel
import com.apps.bookshelf.ui.viewmodel.BooksViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookshelfApp() {

    val context = LocalContext.current

    val application = context.applicationContext
            as BookShelfApplication

    val factory = remember(application) {
        BooksViewModelFactory(
            application.container.booksRepository
        )
    }

    val booksViewModel: BooksViewModel = viewModel(
        factory = factory
    )

    val uiState by booksViewModel.uiState.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Book Shelf")
                }
            )
        }
    ) { innerPadding ->
        BookshelfScreen(
            uiState = uiState,
            onRetry = booksViewModel::getBooks,
            modifier = Modifier.padding(innerPadding)
        )
    }
}