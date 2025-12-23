package com.example.rssapp.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.compose.runtime.*
import androidx.lifecycle.viewModelScope
import com.example.rssapp.data.SelectedFeedsStorage
import com.example.rssapp.models.FeedOption
import kotlinx.coroutines.launch

class SelectedFeedsViewModel(
    application: Application
) : AndroidViewModel(application) {

    var selectedFeeds by mutableStateOf<List<FeedOption>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            val saved = SelectedFeedsStorage.load(getApplication())
            selectedFeeds = saved ?: defaultFeeds()
        }
    }

    fun updateSelected(newSelection: List<FeedOption>) {
        selectedFeeds = newSelection
        viewModelScope.launch {
            SelectedFeedsStorage.save(getApplication(), newSelection)
        }
    }

    private fun defaultFeeds() = listOf(
        FeedOption("Pääuutiset", "https://yle.fi/rss/uutiset/paauutiset", true),
        FeedOption("Tuoreimmat", "https://yle.fi/rss/uutiset/tuoreimmat", true),
        FeedOption("Luetuimmat", "https://yle.fi/rss/uutiset/luetuimmat", true)
    )
}
