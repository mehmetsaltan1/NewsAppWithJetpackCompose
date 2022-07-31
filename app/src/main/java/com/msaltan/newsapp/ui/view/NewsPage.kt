package com.msaltan.newsapp.ui.view

import android.content.Context
import android.util.Log
import android.widget.Toolbar
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.msaltan.newsapp.models.Articles
import com.msaltan.newsapp.ui.CustomNewsCard
import com.msaltan.newsapp.viewmodel.NewsPageViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.msaltan.newsapp.navigation.Screen
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@ExperimentalMaterialApi
@Composable
fun NewsPage(navController: NavController){
    val newsPageViewModel = viewModel(modelClass = NewsPageViewModel::class.java)
    val state by newsPageViewModel.state.collectAsState()
    LazyColumn {
        if (state.isEmpty()) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(align = Alignment.Center)
                )
            }

        }

        itemsIndexed(items = state){ index, item ->
            CustomNewsCard(news = item,onClick = {
               navController.navigate(Screen.NewsDetailScreen.withArgs(URLEncoder.encode(item.url, StandardCharsets.UTF_8.toString())))
            })
        }

    }

}


