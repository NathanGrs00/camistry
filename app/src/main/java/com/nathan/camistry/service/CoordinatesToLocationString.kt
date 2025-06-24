package com.nathan.camistry.service

import android.content.Context
import android.location.Geocoder
import java.util.Locale

class CoordinatesToLocationString {
    fun getCityName(context: Context, latitude: Double, longitude: Double): String {
        return try {
            val geocoder = Geocoder(context, Locale.getDefault())
            val addresses = geocoder.getFromLocation(latitude, longitude, 1)
            if (!addresses.isNullOrEmpty()) {
                addresses[0].locality ?: "Unknown city"
            } else {
                "Unknown city"
            }
        } catch (e: Exception) {
            "Unknown city"
        }
    }
}