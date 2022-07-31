package com.msaltan.newsapp.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.msaltan.newsapp.ui.view.DetailPage
import com.msaltan.newsapp.ui.view.NewsPage

@ExperimentalMaterialApi
@Composable
fun Navigation(){
 val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.NewsListScreen.route){
        composable(route = Screen.NewsListScreen.route) {
         NewsPage(navController = navController)
        }
        composable(route = Screen.NewsDetailScreen.route + "/{url}",
        arguments = listOf(
            navArgument("url"){
                type = NavType.StringType
                defaultValue = "www.google.com"
                nullable = true
            }
        )){ data ->
            DetailPage(newsUrl = data.arguments?.getString("url") )
        }
    }
}