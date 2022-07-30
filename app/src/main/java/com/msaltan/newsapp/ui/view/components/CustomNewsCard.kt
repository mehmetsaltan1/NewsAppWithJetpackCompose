package com.msaltan.newsapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.msaltan.newsapp.models.Articles

@ExperimentalMaterialApi
@Composable
fun CustomNewsCard(
    news:Articles,
    onClick : () -> Unit
) {
    Card(

        modifier = Modifier
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            )
            .wrapContentHeight()
            .fillMaxWidth(),

        elevation = 8.dp,
       onClick = onClick
    ) {
        Column() {
                SubcomposeAsyncImage(
                    modifier = Modifier.fillMaxWidth(),
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
                    text = news.title!!,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 8.dp,
                            vertical = 8.dp
                        )
                        .wrapContentWidth(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.h6
                )

                Text(
                    text = news.description!!,
                    color = Color.Gray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 8.dp,
                        )
                        .wrapContentWidth(Alignment.CenterHorizontally)

                    ,
                    style = MaterialTheme.typography.h6
                )


        }
    }
}