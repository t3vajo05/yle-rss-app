package com.example.rssapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rssapp.models.FeedOption
import com.example.rssapp.ui.viewmodels.SelectedFeedsViewModel
import androidx.compose.ui.res.stringResource
import com.example.rssapp.R

@Composable
fun FeedSelectionScreen(
    navController: NavController,
    availableFeeds: List<FeedOption>,
    selectedFeedsViewModel: SelectedFeedsViewModel,
    onConfirm: (List<FeedOption>) -> Unit
) {
    // Initialize feeds with pre-checked selection based on ViewModel
    var feeds by remember {
        mutableStateOf(
            availableFeeds.map { feed ->
                val isSelected = selectedFeedsViewModel.selectedFeeds.any { it.name == feed.name }
                feed.copy(selected = isSelected)
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.choose_feeds),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(feeds) { feed ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = feed.name, style = MaterialTheme.typography.bodyLarge)
                    Checkbox(
                        checked = feed.selected,
                        onCheckedChange = { checked ->
                            feeds = feeds.map {
                                if (it.name == feed.name) it.copy(selected = checked) else it
                            }
                        }
                    )
                }
            }
        }

        Button(
            onClick = {
                val selected = feeds.filter { it.selected }
                selectedFeedsViewModel.updateSelected(selected)
                navController.popBackStack()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(stringResource(R.string.confirm_selection))
        }

    }
}
