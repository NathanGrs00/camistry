package com.nathan.camistry.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nathan.camistry.MainActivity
import com.nathan.camistry.R
import com.nathan.camistry.controller.LoginController
import com.nathan.camistry.repository.LoginRepository
import com.nathan.camistry.ui.register.RegisterActivity
import com.nathan.camistry.ui.register.SetupProfileActivity
import com.nathan.camistry.util.InputUtil

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etEmail = findViewById<EditText>(R.id.et_email)
        val etPassword = findViewById<EditText>(R.id.et_password)
        val btnLogin = findViewById<Button>(R.id.btn_next)
        val btnRegister = findViewById<TextView>(R.id.tv_signup)

        val loginRepository = LoginRepository()
        val loginController = LoginController(loginRepository)

        //TODO: remove this
        val intent = Intent(this, SetupProfileActivity::class.java)
        startActivity(intent)

        btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            etEmail.error = null
            etPassword.error = null

            val inputEmail = InputUtil.sanitizeInput(etEmail.text.toString())
            val inputPassword = InputUtil.sanitizeInput(etPassword.text.toString())

            val emailError = loginController.validateEmail(inputEmail)
            val passwordError = loginController.validatePassword(inputPassword)

            if (emailError != null) {
                etEmail.error = emailError
                return@setOnClickListener
            }

            if (passwordError != null) {
                etPassword.error = passwordError
                return@setOnClickListener
            }

            loginController.login(inputEmail, inputPassword) { success, errorMsg ->
                if (success) {
                    Toast.makeText(this,
                        getString(R.string.login_successful),
                        Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this,
                        errorMsg ?: getString(R.string.login_failed),
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}