package com.nathan.camistry.ui.profile

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.nathan.camistry.R
import com.nathan.camistry.controller.UserController
import com.nathan.camistry.repository.UserRepository

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val testText = findViewById<TextView>(R.id.tv_teststring)
        val userRepository = UserRepository()
        val userController = UserController(userRepository)
        val userId = FirebaseAuth.getInstance().uid
        if (userId == null) {
            testText.text = "User not authenticated"
            return
        }
        userController.getUser(userId) { user ->
            if (user != null) {
                testText.text = "Welcome, ${user.firstName}!"
            } else {
                testText.text = "User not found"
            }
        }
    }
}