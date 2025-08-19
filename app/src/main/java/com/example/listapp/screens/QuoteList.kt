package com.example.listapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.listapp.models.Quote

//listitem cha used karun list create karnar

    @Composable
    fun QuoteList(data: Array<Quote>, onClick: () -> Unit) {
        LazyColumn(content = {            // data pass and  all items render to QuoteListItem
            items(data) {
                QuoteListItem(quote = it) {
                    onClick()
                }
            }
        })
        // testing
    }



