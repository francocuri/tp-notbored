package com.example.nobored.model

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiServices {

    @GET
    fun getActivitiesNoBored(): Response<Activities>
}