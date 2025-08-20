package com.example.listapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.listapp.models.Quote
import com.google.gson.Gson


//data maintain and file read
object DataManager {

    var data = emptyArray<Quote>()  //alela data store in this array
   var currentQuote:Quote? = null
    var currentPage = mutableStateOf(Pages.LISTING)

    var isDataLoaded = mutableStateOf(false)   //data not loaded yet
    fun loadAssetsFromFile(context: Context) {
        val inputStream = context.assets.open("quotes.json")  //open file
        val size: Int = inputStream.available()        // read file
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)       //convert it into string
        val gson = Gson()     //json format data convert into kolin object
        data = gson.fromJson(json, Array<Quote>::class.java)         // store this json file data into array and store in data
        isDataLoaded.value = true   //data loaded
    }

    fun switchPages(quote: Quote?) {
        if (currentPage.value == Pages.LISTING) {
            currentQuote = quote
            currentPage.value = Pages.DETAIL
        } else {
            currentPage.value = Pages.LISTING
        }
    }

}
