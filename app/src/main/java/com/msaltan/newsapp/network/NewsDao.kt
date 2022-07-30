package com.msaltan.newsapp.network

import com.msaltan.newsapp.models.News
import retrofit2.Call
import retrofit2.http.GET

interface NewsDao {
    @GET("v2/top-headlines?country=us&apiKey=7e2876177804465db0b898b6b5f0cd94")
   suspend fun allNews(): News
}