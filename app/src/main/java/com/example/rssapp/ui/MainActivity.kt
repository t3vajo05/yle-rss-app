package com.example.rssapp.ui

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rssapp.data.allFeeds
import com.example.rssapp.models.FeedOption
import com.example.rssapp.ui.screens.FeedSelectionScreen
import com.example.rssapp.ui.screens.RssPagerScreen
import com.example.rssapp.ui.viewmodels.SelectedFeedsViewModel

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    val navController = rememberNavController()
                    val selectedFeedsViewModel: SelectedFeedsViewModel = viewModel()

                    NavHost(
                        navController = navController,
                        startDestination = "rss"
                    ) {
                        // Pager screen showing selected feeds
                        composable("rss") {
                            RssPagerScreen(
                                selectedFeedsViewModel = selectedFeedsViewModel,
                                onSelectFeeds = { navController.navigate("feed_selection") }
                            )
                        }

                        // Feed selection screen
                        composable("feed_selection") {
                            FeedSelectionScreen(
                                navController = navController,
                                availableFeeds = allFeeds,
                                selectedFeedsViewModel = selectedFeedsViewModel
                            ) { selectedFeeds ->
                                // Update ViewModel with new selection
                                selectedFeedsViewModel.updateSelected(selectedFeeds)
                                // Navigate back to pager screen
                                navController.popBackStack()
                            }
                        }
                    }
                }
            }
        }
    }
}
