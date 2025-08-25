package com.example.catsapp.composables

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.catsapp.CatsList.CatListEntry
import com.example.catsapp.CatsList.CatsListViewModel

@Composable
fun CatCard(
    cat: CatListEntry, navController: NavController, viewModel: CatsListViewModel
) {

    val referenceImageId = cat.imageId
    val imageEntry = viewModel.images[referenceImageId]

    val encodedUrl = Uri.encode(imageEntry)

    LaunchedEffect(referenceImageId) {
        viewModel.loadImageById(referenceImageId)
    }

    Box(
        Modifier
            .width(200.dp)
            .height(200.dp)
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(188.dp)
                .clip(RoundedCornerShape(10.dp))
                .clickable(onClick = { navController.navigate("cat_details_screen/${cat.breed}/${encodedUrl}") })
        ) {
            if(imageEntry != null) {
            AsyncImage(
                model = imageEntry,
                contentDescription = "Cat photo",
                contentScale = ContentScale.Crop, modifier = Modifier
                    .fillMaxWidth()
            ) } else {
                Text("Loading image...")
            }


        }
        Text(
            text = cat.breed,
            fontSize = 11.sp,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = 7.dp)
                .padding(start = 7.dp)
        )
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset(x = (-8).dp, y = (-10).dp)
        ) {
            FavoriteButton()
        }
    }
}