package com.example.catsapp.data.responses

data class Image(
    val breeds: List<BreedsItem>,
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
)