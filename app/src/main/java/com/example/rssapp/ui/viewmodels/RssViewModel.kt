package com.example.rssapp.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rssapp.data.RssRepository
import com.example.rssapp.models.RssItem
import kotlinx.coroutines.launch

class RssViewModel(private val repository: RssRepository = RssRepository()) : ViewModel() {

    var rssItems by mutableStateOf<List<RssItem>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun loadFeed(url: String) {
        viewModelScope.launch {
            try {
                isLoading = true
                errorMessage = null
                rssItems = repository.getFeed(url)
            } catch (e: Exception) {
                errorMessage = "Error: ${e.message}"
            } finally {
                isLoading = false
            }
        }
    }
}
