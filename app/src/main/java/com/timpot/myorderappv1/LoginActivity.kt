package com.timpot.myorderappv1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat

class LoginActivity : AppCompatActivity() {
    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var textViewSignup: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
        buttonLogin = findViewById(R.id.buttonLogin)
        buttonLogin.setBackgroundColor(ContextCompat.getColor(this, R.color.orange))

        editTextUsername = findViewById(R.id.editTextUsername)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        textViewSignup = findViewById(R.id.textViewSignup)

        buttonLogin.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            // Perform login authentication here

            // Redirect to the main screen if login is successful
            val intent = Intent(this, OrderFoodActivity::class.java)
            startActivity(intent)
            finish()
        }

        textViewSignup.setOnClickListener {
            // Handle the signup action here
        }
    }
}