package com.msaltan.newsapp.network

class ApiUtils {
    companion object{
        private const val BASE_URL="https://newsapi.org/"
        fun getNewsDao():NewsDao{
            return RetrofitClient.getClient(BASE_URL).create(NewsDao::class.java)
        }
    }
}