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
    //var newsList:List<Articles>
    var newsDao:NewsDao = ApiUtils.getNewsDao()
init {
    //getAllNews()
    //newsList = arrayListOf()
}
    suspend fun getNews():News{
        return  newsDao.allNews()
    }
/*    fun getAllNews(){
        newsDao.allNews().enqueue(object : Callback<News> {
            override fun onFailure(call: Call<News>?, t: Throwable?) {}
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val list = response.body()!!.articles
                newsList = list
                Log.e("dsa","$newsList")
            }
        })
    }*/
}