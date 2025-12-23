package com.example.rssapp.data

import com.example.rssapp.models.RssItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup

class RssRepository {

    suspend fun getFeed(url: String): List<RssItem> = withContext(Dispatchers.IO) {
        val doc = Jsoup.connect(url).get()
        val items = doc.select("item")
        items.map { element ->
            RssItem(
                title = element.selectFirst("title")?.text() ?: "",
                description = element.selectFirst("description")?.text() ?: "",
                link = element.selectFirst("link")?.text() ?: "",
                pubDate = element.selectFirst("pubDate")?.text() ?: ""
            )
        }
    }
}
