package com.nathan.camistry.controller

import com.nathan.camistry.util.ValidationUtil

class LoginController {
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
}