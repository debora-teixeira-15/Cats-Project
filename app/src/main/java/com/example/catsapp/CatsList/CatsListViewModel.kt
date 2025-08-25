package com.example.catsapp.CatsList

import android.util.Log
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catsapp.data.repository.CatsRepository
import com.example.catsapp.utils.Resource
import kotlinx.coroutines.launch
import kotlin.collections.map

class CatsListViewModel (
    val repository: CatsRepository
) : ViewModel() {

    init {
        loadCats()
    }
    var catsList = mutableStateOf<List<CatListEntry>>(listOf())

    val images = mutableStateMapOf<String, String>()
    fun loadCats() {
        viewModelScope.launch {
            val result = repository.getBreeds()
            when (result) {
                is Resource.Success<*> -> {
                    val catsEntries = result.data!!.map { i ->
                        CatListEntry(
                            breed = i.name,
                            imageId = i.reference_image_id
                        )
                    }
                    catsList.value = catsEntries
                }

                is Resource.Loading<*> -> TODO()
                is Resource.Error<*> -> Log.d("error", result.message!!)
            }
        }
    }

    fun loadImageById(id: String)  {
        if (images.containsKey(id)) return

        viewModelScope.launch {
            val result = repository.getImageById(id)
            when (result) {
                is Resource.Success<*> -> {
                    val url = result.data!!.url
                    images[id] = url
                }

                is Resource.Loading<*> -> TODO()
                is Resource.Error<*> -> Log.d("error", result.message!!)
            }
        }
    }
}