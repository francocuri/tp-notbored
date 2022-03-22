package com.example.nobored.model

data class Activities(
    val activity: List<String> = listOf(
        "Education", "Recreational", "Social", "Diy", "Charity",
        "Cooking", "Relaxation", "Music", "Busywork"
    ), val type: String, val participants: Int, val price: Int
)
