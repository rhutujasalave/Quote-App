package com.example.listapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import com.example.listapp.screens.ListDetails
import com.example.listapp.screens.QuoteListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {             // used corotine bcoz we want to execute on background tread

            DataManager.loadAssetsFromFile(applicationContext)   //data load  if it mention ouside the corotine means data execute on main tread

        }
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    if (DataManager.isDataLoaded.value) {                //if data is loaded then render to QuoteListScreen composable
        QuoteListScreen(data = DataManager.data) {
        }
    } else {                                   // shows loading... screen
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)
        ) {
            Text(
                text = "Loading....",
                style = MaterialTheme.typography.titleLarge
            )
        }
    }


}
