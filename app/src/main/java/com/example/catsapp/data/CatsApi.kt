package com.example.catsapp.data

import com.example.catsapp.data.responses.BreedsItem
import com.example.catsapp.data.responses.Image
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CatsApi {

    @GET("breeds")
    suspend fun getBreeds(
        @Query("limit") limit: Int,
        @Query("page") page: Int
    ) : List<BreedsItem>

    @GET("breeds/search")
    suspend fun getSpecificBreed(
        @Query("q") breedName: String
    ) : List<BreedsItem>

    @GET("images/{image_id}")
    suspend fun getImageById(
        @Path("image_id") imageId: String
    ): Image
}