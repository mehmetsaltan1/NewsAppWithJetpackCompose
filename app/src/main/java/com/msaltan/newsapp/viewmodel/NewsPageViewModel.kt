package com.msaltan.newsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.msaltan.newsapp.models.Articles
import com.msaltan.newsapp.repository.NewsRepository

class NewsPageViewModel : ViewModel() {
    private val newsRepo = NewsRepository()
    var newsList = MutableLiveData<List<Articles>>()

    init {
        loadNews()
        newsList = newsRepo.getNews()
    }

    fun loadNews() {
        newsRepo.getAllNews()
    }
}