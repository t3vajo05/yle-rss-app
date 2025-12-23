package com.example.rssapp.models

import kotlinx.serialization.Serializable

@Serializable
data class FeedOption(
    val name: String,
    val url: String,
    var selected: Boolean = false
)
