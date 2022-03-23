package com.example.nobored.model

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiServices {

    @GET("api/activity?")
    suspend fun getActivitiesNoBored(
        @Query("type") type: String, @Query("participants") participants : Int
    ): Response<ResponseActivity>

}