package com.example.catsapp.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter


@Composable
fun FavoriteButton() {
    var isFavorite by remember { mutableStateOf(false) }

    Image(
        imageVector = if (isFavorite) Icons.Outlined.Favorite else Icons.Outlined.FavoriteBorder,
        contentDescription = "Favorite",
        colorFilter = ColorFilter.tint(if (isFavorite) Color.Red else Color.LightGray),
        modifier = Modifier.clickable {
            isFavorite = !isFavorite
        }

    )
}
