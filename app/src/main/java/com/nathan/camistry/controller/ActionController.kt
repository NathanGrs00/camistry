package com.nathan.camistry.controller

import com.nathan.camistry.repository.ActionRepository

class ActionController(
    private val actionRepository: ActionRepository = ActionRepository()
) {
    fun likeUser(currentUserId: String, targetUserId: String, onResult: (isMatch: Boolean) -> Unit) {
        actionRepository.likeUser(currentUserId, targetUserId, onResult)
    }

    fun passUser(currentUserId: String, targetUserId: String, onResult: (Boolean) -> Unit) {
        actionRepository.passUser(currentUserId, targetUserId, onResult)
    }
}