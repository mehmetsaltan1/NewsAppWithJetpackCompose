package com.msaltan.newsapp.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.msaltan.newsapp.models.Articles
import com.msaltan.newsapp.models.News
import com.msaltan.newsapp.network.ApiUtils
import com.msaltan.newsapp.network.NewsDao
import retrofit2.Call
import retrofit2.Response

class NewsRepository {
    var newsList:MutableLiveData<List<Articles>>
    var newsDao:NewsDao

    init {
        newsList = MutableLiveData()
        newsDao = ApiUtils.getNewsDao()
    }
    fun getNews():MutableLiveData<List<Articles>>{
        return  newsList
    }
    fun getAllNews(){
        newsDao.allNews().enqueue(object : retrofit2.Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val list = response.body()!!.articles
                newsList.value = list
                Log.e("news","$list")
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.e("news","$t")
            }

        })
    }
}