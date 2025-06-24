package com.nathan.camistry.controller

import android.location.Location
import com.nathan.camistry.model.DiscoverPreferences
import com.nathan.camistry.model.User
import com.nathan.camistry.repository.UserRepository
import com.nathan.camistry.service.DistanceCalculator
import com.nathan.camistry.service.FilterUsersService

class UserController(private val userRepository: UserRepository) {
    private val distanceCalculator = DistanceCalculator()
    private val filterUsersService = FilterUsersService(distanceCalculator)
    fun getUser(userId: String, onResult: (User?) -> Unit){
        userRepository.getUser(userId, onResult)
    }

    fun updateUser(user: User, onResult: (Boolean) -> Unit) {
        userRepository.updateUser(user, onResult)
    }

    fun deleteUser(userId: String, onResult: (Boolean) -> Unit) {
        userRepository.deleteUser(userId, onResult)
    }

    private fun getAllUsers(onResult: (List<User>) -> Unit) {
        userRepository.getAllUsers(onResult)
    }

    fun getFilteredUsers(
        preferences: DiscoverPreferences,
        currentUserLocation: Location,
        onResult: (List<User>) -> Unit
    ) {
        getAllUsers { allUsers ->
            val filtered = filterUsersService.filterUsers(allUsers, preferences, currentUserLocation)
            onResult(filtered)
        }
    }
}