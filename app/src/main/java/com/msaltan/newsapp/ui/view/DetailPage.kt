package com.msaltan.newsapp.ui.view

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.msaltan.newsapp.navigation.Screen


@Composable
fun DetailPage(newsUrl: String?, navController: NavController) {

    Scaffold(
        topBar = { TopAppBar(title = { Text("Details") }) },

        ) {
        Column(modifier = Modifier.fillMaxSize(), Arrangement.SpaceAround) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(550.dp)
            ) {
                AndroidView(factory = {
                    WebView(it).apply {
                        webViewClient = WebViewClient()
                        loadUrl(newsUrl!!)
                    }
                }, update = {
                    it.loadUrl(newsUrl!!)
                })
            }
            Box(modifier = Modifier.fillMaxSize()) {
                Button(onClick = {
                    navController.navigate(Screen.NewsListScreen.route)
                }, modifier = Modifier.align(Alignment.Center)) {
                    Text(text = " Go News List !")
                }
            }
        }
    }
}
