package com.msaltan.newsapp.network

import com.msaltan.newsapp.models.News
import retrofit2.Call
import retrofit2.http.GET

interface NewsDao {
    @GET
    fun allNews():Call<News>
}