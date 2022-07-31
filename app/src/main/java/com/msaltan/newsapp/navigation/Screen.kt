package com.msaltan.newsapp.navigation

sealed class Screen(val route:String){
    object NewsListScreen:Screen("news_list_screen")
    object NewsDetailScreen:Screen("news_detail_screen")
    fun withArgs(vararg args:String):String{
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }
}
