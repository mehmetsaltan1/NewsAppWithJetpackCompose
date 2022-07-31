package com.msaltan.newsapp.network

class ApiUtils {
    companion object {
        private const val BASE_URL = "https://newsapi.org/"
        const val endPoint = "v2/top-headlines?sources=bbc-news&apiKey=7e2876177804465db0b898b6b5f0cd94"
        fun getNewsDao(): NewsDao {
            return RetrofitClient.getClient(BASE_URL).create(NewsDao::class.java)
        }
    }
}