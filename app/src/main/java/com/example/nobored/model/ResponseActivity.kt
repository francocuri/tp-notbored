package com.example.nobored.model

data class ResponseActivity(
    val activity: String,
    val type: String,
    val participants: Int,
    val price: Double,
    val error: String
)
