package com.example.catsapp.data.repository

import com.example.catsapp.data.CatsApi
import com.example.catsapp.data.responses.BreedsItem
import com.example.catsapp.utils.Resource
import java.lang.Exception

class CatsRepository(
    val catsApi: CatsApi
) {

    suspend fun getBreeds() : Resource<List<BreedsItem>>{
        val response = try {
            catsApi.getBreeds(limit = 16, page = 0)
        } catch (e: Exception) {
            return Resource.Error("Unknown error: " + e.message)
        }
        return Resource.Success(response)
    }
}