package com.example.listapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.listapp.R
import com.example.listapp.models.Quote


@Composable
fun QuoteListItem(quote: Quote,onClick: ()-> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .clickable { onClick() }
            .padding(8.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp))
        {
            Image(
                painter = painterResource(id = R.drawable.img),  // your drawable image here
//                imageVector = Icons.Filled.FormatQuote,
//                colorFilter = ColorFilter.tint(Color.White),    //shows icon in white colour
                alignment = Alignment.TopStart,
                contentDescription = "Quote",
                modifier = Modifier.size(40.dp)
//                    .rotate(180f)          //for rotate image
//                    .background(Color.Black)
            )
            Spacer(modifier = Modifier.padding(4.dp))    //to add space
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = quote.text,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
                )
                Box(
                    modifier = Modifier.background(Color(0xFFEEEEEE))
                        .fillMaxWidth(.4f)    //half line 40% line of width
                        .height(1.dp)
                )

                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Thin,
                    modifier = Modifier.padding(top = 4.dp)
                )

            }
        }
    }

}


