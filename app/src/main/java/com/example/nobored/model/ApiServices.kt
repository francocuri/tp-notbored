package com.example.nobored.model

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiServices {

    /**
     * We use @Query because we need to set the parameters for the query
     */

    @GET("api/activity?")
    suspend fun getActivitiesNotBored(
        @Query("type") type: String, @Query("participants") participants : Int
    ): Response<ResponseActivity>

    @GET("api/activity?")
    suspend fun getRandomActivity(
        @Query("participants") participants : Int
    ): Response<ResponseActivity>


}