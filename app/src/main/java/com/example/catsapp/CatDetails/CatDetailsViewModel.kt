package com.example.catsapp.CatDetails

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catsapp.data.repository.CatsRepository
import com.example.catsapp.utils.Resource
import kotlinx.coroutines.launch

class CatDetailsViewModel(val repository: CatsRepository) : ViewModel() {

    var catBreed by mutableStateOf(CatDetailsEntry("", "", ""))

    fun loadSpecificCat(breedName: String) {
        viewModelScope.launch {
            val result = repository.getSpecificBreed(breedName)
            when (result) {
                is Resource.Success<*> -> {
                    val newCatInfo = CatDetailsEntry(
                        result.data!![0].origin,
                        result.data[0].temperament,
                        result.data[0].description
                    )
                    catBreed = newCatInfo
                }

                is Resource.Loading<*> -> TODO()
                is Resource.Error<*> -> Log.d("error", result.message!!)
            }
        }
    }
}