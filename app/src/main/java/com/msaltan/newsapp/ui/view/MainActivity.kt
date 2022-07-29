package com.msaltan.newsapp.ui.view

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.msaltan.newsapp.models.Articles
import com.msaltan.newsapp.repository.NewsRepository
import com.msaltan.newsapp.ui.theme.NewsAppTheme
import com.msaltan.newsapp.viewmodel.NewsPageViewModel

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: NewsPageViewModel
private lateinit var newsList:List<Articles>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: NewsPageViewModel by viewModels()
        viewModel = tempViewModel
        val repo = NewsRepository()
        repo.getAllNews()
        setContent {
            NewsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        viewModel.newsList.observe(this,{
         newsList = it
            Log.e("news2","$it")
        })
        return super.onCreateView(name, context, attrs)
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewsAppTheme {
        Greeting("Android")
    }
}