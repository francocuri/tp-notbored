package com.example.nobored

object Utils {
    fun convertPrice(priceDouble: Double?): String {
        return when (priceDouble!!) {
            0.0 -> "Free"
            in 0.1..0.3 -> "Low"
            in 0.4..0.6 -> "Medium"
            else -> "High"
        }
    }
}