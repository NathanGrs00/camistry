package com.nathan.camistry.util

object ValidationUtil {
    fun validateEmail(email: String): String? {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()
        return if (email.isBlank()) {
            "Email cannot be empty"
        } else if (!email.matches(emailRegex)) {
            "Invalid email format"
        } else {
            null
        }
    }

    fun validatePassword(password: String): String? {
        return if (password.isBlank()) {
            "Password cannot be empty"
        } else if (password.length < 8) {
            "Password must be at least 8 characters"
        } else {
            null
        }
    }
}