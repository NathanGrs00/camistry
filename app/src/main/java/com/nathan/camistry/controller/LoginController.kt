package com.nathan.camistry.controller

import com.nathan.camistry.repository.LoginRepository
import com.nathan.camistry.util.ValidationUtil

class LoginController {
    private val repository = LoginRepository()

    fun sanitizeInput(input: String): String {
        // Remove leading and trailing whitespace
        return input.trim()
    }

    fun validateEmail(email: String): String? {
        return ValidationUtil.validateEmail(email)
    }

    fun validatePassword(password: String): String? {
        return ValidationUtil.validatePassword(password)
    }

    fun login(email: String, password: String, callback: (Boolean, String?) -> Unit) {
        repository.login(email, password, callback)
    }
}