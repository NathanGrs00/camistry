package com.nathan.camistry.controller

import com.nathan.camistry.model.User
import com.nathan.camistry.repository.UserRepository

class UserController(private val userRepository: UserRepository) {
    fun getUser(userId: String, onResult: (User?) -> Unit){
        return userRepository.getUser(userId, onResult)
    }

    fun updateUser(user: User, onResult: (Boolean) -> Unit) {
        userRepository.updateUser(user, onResult)
    }

    fun deleteUser(userId: String, onResult: (Boolean) -> Unit) {
        userRepository.deleteUser(userId, onResult)
    }
}