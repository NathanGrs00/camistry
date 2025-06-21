package com.nathan.camistry.ui.register

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nathan.camistry.R
import com.nathan.camistry.controller.RegisterController
import com.nathan.camistry.repository.RegisterRepository
import com.nathan.camistry.util.InputUtil

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val etEmail = findViewById<EditText>(R.id.et_email)
        val etPassword = findViewById<EditText>(R.id.et_password)
        val btnRegister = findViewById<Button>(R.id.btn_register)
        val registerRepository = RegisterRepository()
        val registerController = RegisterController(registerRepository)

        btnRegister.setOnClickListener {
            etEmail.error = null
            etPassword.error = null

            val inputEmail = InputUtil.sanitizeInput(etEmail.text.toString())
            val inputPassword = InputUtil.sanitizeInput(etPassword.text.toString())

            val emailError = registerController.validateEmail(inputEmail)
            val passwordError = registerController.validatePassword(inputPassword)

            if (emailError != null) {
                etEmail.error = emailError
                return@setOnClickListener
            }

            if (passwordError != null) {
                etPassword.error = passwordError
                return@setOnClickListener
            }

            registerController.register(inputEmail, inputPassword) { success, errorMsg ->
                if (success) {
                    Toast.makeText(this,
                        getString(R.string.registration_successful),
                        Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, SetupProfileActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this,
                        errorMsg ?: getString(R.string.registration_failed),
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}