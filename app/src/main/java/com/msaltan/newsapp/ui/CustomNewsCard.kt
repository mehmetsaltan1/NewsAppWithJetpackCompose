package com.msaltan.newsapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.msaltan.newsapp.models.Articles

@Composable
fun CustomNewsCard(
    news:Articles
) {
    Card(

        modifier = Modifier
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            )
            .height(300.dp)
            .fillMaxWidth(),

        elevation = 8.dp,

    ) {
        Column() {
            news.title?.let { title ->
                SubcomposeAsyncImage(
                    model = news.urlToImage,
                    contentDescription = "https://example.com/image.jpg"
                ) {
                    val state = painter.state
                    if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                        CircularProgressIndicator()
                    } else {
                        SubcomposeAsyncImageContent()
                    }
                }

                Text(
                    text = "Uzay Aracı :"+title,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.h5
                )
                val astronot = news.description
                Text(
                    text = "Astronot :"+astronot,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)

                    ,
                    style = MaterialTheme.typography.h6
                )

            }
        }
    }
}