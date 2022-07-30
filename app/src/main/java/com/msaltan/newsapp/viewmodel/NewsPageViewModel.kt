package com.msaltan.newsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msaltan.newsapp.models.Articles

import com.msaltan.newsapp.repository.NewsRepository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsPageViewModel : ViewModel() {
    private val newsRepo = NewsRepository()
    private val _state = MutableStateFlow(emptyList<Articles>())
        val state:StateFlow<List<Articles>>
        get() = _state

    init {
      //  loadNews()
       viewModelScope.launch {
           val news = newsRepo.getNews()
              _state.value = news.articles
       }
    }

/*    private fun loadNews() {
        newsRepo.getAllNews()
    }*/
}