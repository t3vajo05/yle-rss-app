package com.example.rssapp.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rssapp.models.RssItem
import com.example.rssapp.components.formatFinnishTime

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RssListScreen(
    rssItems: List<RssItem>,
    isLoading: Boolean,
    errorMessage: String?,
    modifier: Modifier = Modifier,
    onItemClick: (RssItem) -> Unit = {}
) {
    Box(modifier = modifier.fillMaxSize()) {
        when {
            isLoading -> CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            errorMessage != null -> Text(
                text = errorMessage,
                modifier = Modifier.align(Alignment.Center)
            )
            else -> LazyColumn(
                modifier = Modifier.padding(8.dp)
            ) {
                items(rssItems) { item ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .clickable { onItemClick(item) }
                    ) {
                        Text(text = item.title, style = MaterialTheme.typography.bodyLarge)

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(text = item.description, style = MaterialTheme.typography.bodyMedium)

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(text = formatFinnishTime(item.pubDate),style = MaterialTheme.typography.bodySmall)

                        Spacer(modifier = Modifier.height(4.dp))
                        Divider()
                    }
                }
            }
        }
    }
}
