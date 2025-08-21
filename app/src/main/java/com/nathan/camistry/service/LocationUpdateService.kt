package com.nathan.camistry.service

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.location.Location
import android.util.Log
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.LocationServices
import com.nathan.camistry.model.UserLocation
import com.nathan.camistry.repository.UserRepository

class LocationUpdateService(
    private val activity: Activity,
    private val userRepository: UserRepository
) {
    fun updateUserLocation(userId: String) {
        if (ActivityCompat.checkSelfPermission(
                activity,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // Permission not granted
            return
        }
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(activity)
        fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
            location?.let {
                userRepository.getUser(userId) { user ->
                    user?.let {
                        val userLocation = UserLocation(location.latitude, location.longitude)
                        val updatedUser = it.copy(location = userLocation)
                        userRepository.updateUser(updatedUser) { success ->
                            if (!success) {
                                Log.e("LocationUpdateService",
                                    "Failed to update user location for userId: $userId")
                            }
                        }
                    }
                }
            }
        }
    }

    fun getCurrentLocation(onResult: (Location?) -> Unit) {
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(activity)
        if (ActivityCompat.checkSelfPermission(
                activity,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            onResult(null)
            return
        }
        fusedLocationClient.lastLocation.addOnSuccessListener { location: android.location.Location? ->
            onResult(location)
        }
    }
}