package com.msaltan.newsapp.ui.view

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun DetailPage(newsUrl:String?){
 Column(modifier = Modifier.fillMaxSize()) {
     Text(text = "URL : $newsUrl")
 }

}