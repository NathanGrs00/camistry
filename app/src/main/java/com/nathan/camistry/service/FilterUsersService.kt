package com.nathan.camistry.service

import android.location.Location
import com.nathan.camistry.model.DiscoverPreferences
import com.nathan.camistry.model.User


class FilterUsersService(private val distanceCalculator: DistanceCalculator) {
    fun filterUsers(
        allUsers: List<User>,
        preferences: DiscoverPreferences,
        currentUserLocation: Location
    ): List<User> {
        return allUsers.filter { user ->
            user.id != preferences.userId &&
                    user.age in preferences.minAge..preferences.maxAge &&
                    preferences.preferredGender.contains(user.gender) &&
                    distanceCalculator.calculateDistance(currentUserLocation, user.location) <= preferences.maxDistanceKm
        }
    }
}