package com.msaltan.newsapp.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.msaltan.newsapp.models.Articles
import com.msaltan.newsapp.models.News
import com.msaltan.newsapp.network.ApiUtils
import com.msaltan.newsapp.network.NewsDao
import okhttp3.internal.notifyAll
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository {
    var newsDao:NewsDao = ApiUtils.getNewsDao()

    suspend fun getNews():News{
        return  newsDao.allNews()
    }

}