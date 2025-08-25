package com.example.catsapp.CatDetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.catsapp.composables.FavoriteButton
import org.koin.androidx.compose.koinViewModel

@Composable
fun CatDetailsScreen(breedName: String, viewModel: CatDetailsViewModel = koinViewModel() ) {

    viewModel.loadSpecificCat(breedName)
    val catInfo = viewModel.catBreed

    Box(modifier = Modifier.padding(15.dp)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = breedName,
                    modifier = Modifier.weight(1f),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.SansSerif
                )
                FavoriteButton()

            }

            AsyncImage(
                model = "https://images.squarespace-cdn.com/content/v1/607f89e638219e13eee71b1e/1684821560422-SD5V37BAG28BURTLIXUQ/michael-sum-LEpfefQf4rU-unsplash.jpg",
                contentDescription = "Cat Photo",
                contentScale = ContentScale.Crop, modifier = Modifier
                    .padding(top = 50.dp)
                    .align(Alignment.CenterHorizontally)
                    .size(270.dp)
            )
            DetailsSection(catInfo)
        }
    }
}

@Composable
private fun DetailsSection(catInfo: CatDetailsEntry) {
    Box(modifier = Modifier.fillMaxWidth().padding(top = 20.dp)) {
        Column {
            Text(
                text = "Origin: " + catInfo.origin,
                fontSize = 12.sp
            )
            Text(
                text = "Temperament: " + catInfo.temperament,
                fontSize = 12.sp
            )
            Text(
                text = "Description: " + catInfo.description,
                fontSize = 12.sp
            )
        }
    }
}