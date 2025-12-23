package com.example.rssapp.ui.screens

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.rssapp.components.RssListScreen
import com.example.rssapp.models.FeedOption
import com.example.rssapp.ui.viewmodels.RssViewModel
import com.example.rssapp.ui.viewmodels.SelectedFeedsViewModel
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RssPagerScreen(

    selectedFeedsViewModel: SelectedFeedsViewModel,
    viewModel: RssViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    onSelectFeeds: () -> Unit = {}
) {

    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    // Snapshot of selected feeds
    val feeds by remember { derivedStateOf { selectedFeedsViewModel.selectedFeeds.toList() } }

    // Pager state
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { feeds.size.coerceAtLeast(1) },
        initialPageOffsetFraction = 0f
    )

    // Make sure current page is valid after feed list changes
    LaunchedEffect(feeds.size) {
        if (feeds.isNotEmpty() && pagerState.currentPage >= feeds.size) {
            coroutineScope.launch {
                pagerState.scrollToPage(0)
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = "https://images.cdn.yle.fi/image/upload/f_auto,fl_progressive/q_auto/w_2890,h_2890,c_crop,x_632,y_612/w_2890/w_1400,h_1400,c_fit/v1641897373/39-90051461dd5d3129248.jpg",
            contentDescription = "Yle logo",
            modifier = Modifier.size(100.dp).padding(top = 16.dp)
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = feeds.getOrNull(pagerState.currentPage)?.name ?: "",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(16.dp)
            )
            IconButton(onClick = {
                onSelectFeeds()
            }) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Select feeds")
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            val feed = feeds.getOrNull(page) ?: return@HorizontalPager

            LaunchedEffect(feed.url) {
                viewModel.loadFeed(feed.url)
            }

            RssListScreen(
                rssItems = viewModel.rssItems,
                isLoading = viewModel.isLoading,
                errorMessage = viewModel.errorMessage,
                modifier = Modifier.fillMaxSize(),
                onItemClick = { item ->
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.link))
                    context.startActivity(intent)
                }
            )
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            repeat(feeds.size) { index ->
                val isSelected = index == pagerState.currentPage
                Box(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .size(if (isSelected) 12.dp else 8.dp)
                        .background(
                            color = if (isSelected) Color(0xFF00B4C8)
                            else Color(0xFF00B4C8).copy(alpha = 0.3f),
                            shape = MaterialTheme.shapes.small
                        )
                )
            }
        }
    }
}
