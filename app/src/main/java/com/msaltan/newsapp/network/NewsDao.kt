package com.msaltan.newsapp.network

import com.msaltan.newsapp.models.News
import retrofit2.Call
import retrofit2.http.GET

interface NewsDao {
    @GET(ApiUtils.endPoint)
    suspend fun allNews(): News
}