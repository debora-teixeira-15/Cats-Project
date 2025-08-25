package com.example.catsapp.CatsList

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catsapp.data.repository.CatsRepository
import com.example.catsapp.utils.Resource
import kotlinx.coroutines.launch

class CatsListViewModel (
    val repository: CatsRepository
) : ViewModel() {

    init {
        loadCats()
    }
    var catsList = mutableStateOf<List<CatListEntry>>(listOf())

    fun loadCats() {
        viewModelScope.launch {
            val result = repository.getBreeds()
            when (result) {
                is Resource.Success<*> -> {
                    val catsEntries = result.data!!.map { i ->
                        CatListEntry(
                            breed = i.name
                        )
                    }
                    catsList.value = catsEntries
                }

                is Resource.Loading<*> -> TODO()
                is Resource.Error<*> -> Log.d("error", result.message!!)
            }
        }
    }
}