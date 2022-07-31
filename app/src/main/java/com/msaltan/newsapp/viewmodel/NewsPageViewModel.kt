package com.msaltan.newsapp.viewmodel

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
    val state: StateFlow<List<Articles>>
        get() = _state

    init {
        viewModelScope.launch {
            //NewsRepodan veriler alınıp state değişkenine aktarıldı
            val news = newsRepo.getNews()
            _state.value = news.articles
        }
    }

}