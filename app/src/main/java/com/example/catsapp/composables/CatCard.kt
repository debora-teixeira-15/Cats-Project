package com.example.catsapp.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun CatCard(url: String) {
    Box(Modifier.width(200.dp).height(200.dp)) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(188.dp)
                .clip(RoundedCornerShape(10.dp))
        ) {
            AsyncImage(
                model = url,
                contentDescription = "Cat photo",
                contentScale = ContentScale.Crop, modifier = Modifier
                    .fillMaxWidth()
            )


        }
        Text(
            text = "Breed Name",
            fontSize = 11.sp,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .offset(y= 7.dp)
                .padding(start = 7.dp)
        )
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset( x= (-8).dp)
        ) {
            FavoriteButton()
        }
    }
}