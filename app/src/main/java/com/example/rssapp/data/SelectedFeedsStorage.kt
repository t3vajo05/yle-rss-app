package com.example.rssapp.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.rssapp.models.FeedOption
import kotlinx.coroutines.flow.first
import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

private val Context.dataStore by preferencesDataStore(name = "selected_feeds")

object SelectedFeedsStorage {
    private val FEEDS_KEY = stringPreferencesKey("feeds_json")

    suspend fun save(context: Context, feeds: List<FeedOption>) {
        val json = Json.encodeToString(feeds)
        context.dataStore.edit {
            it[FEEDS_KEY] = json
        }
    }

    suspend fun load(context: Context): List<FeedOption>? {
        val prefs = context.dataStore.data.first()
        return prefs[FEEDS_KEY]?.let {
            Json.decodeFromString(it)
        }
    }
}
