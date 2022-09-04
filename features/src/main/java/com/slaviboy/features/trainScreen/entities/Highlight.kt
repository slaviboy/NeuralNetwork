package com.slaviboy.features.trainScreen.entities

data class Highlight(
    val text: String,
    val data: String,
    val onClick: (data: String) -> Unit
)