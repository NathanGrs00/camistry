package com.nathan.camistry.controller

import com.nathan.camistry.repository.RegisterRepository
import com.nathan.camistry.util.ValidationUtil

class RegisterController {
    private val repository = RegisterRepository()

    fun validateEmail(email: String): String? {
        return ValidationUtil.validateEmail(email)
    }

    fun validatePassword(password: String): String? {
        return ValidationUtil.validatePassword(password)
    }

    fun register(email: String, password: String, callback: (Boolean, String?) -> Unit) {
        repository.register(email, password, callback)
    }
}