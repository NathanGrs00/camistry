package com.nathan.camistry.ui.login

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.nathan.camistry.R
import com.nathan.camistry.controller.LoginController

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etEmail = findViewById<EditText>(R.id.et_email)
        val etPassword = findViewById<EditText>(R.id.et_password)

        val loginController = LoginController()
        val inputEmail = loginController.sanitizeInput(etEmail.text.toString())
        val inputPassword = loginController.sanitizeInput(etPassword.text.toString())

        val emailError = loginController.validateEmail(inputEmail)
        val passwordError = loginController.validatePassword(inputPassword)

        val btnLogin = findViewById<Button>(R.id.btn_next)

        btnLogin.setOnClickListener {
            if (emailError != null) {
                etEmail.error = emailError
            }

            if (passwordError != null) {
                etPassword.error = passwordError
            }
        }
    }
}