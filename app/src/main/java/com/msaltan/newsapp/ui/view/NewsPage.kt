package com.msaltan.newsapp.ui.view

import android.util.Log
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
@ExperimentalMaterialApi
@Composable
fun NewsPage(){
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
                Log.e("selected","$item")
            })
        }

    }

}


