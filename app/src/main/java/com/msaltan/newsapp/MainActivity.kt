package com.msaltan.newsapp


import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.msaltan.newsapp.ui.view.NewsPage


class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
       androidx.compose.material.Surface(
           modifier = Modifier.fillMaxSize()
       ) {
           NewsPage()
       }
        }
    }
}


