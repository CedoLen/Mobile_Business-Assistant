package com.example.business_assistant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AuthorizationScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.authorization_screen)
    }

    fun goToRegistration(view: View) {
        val intent = Intent(this, RegistrationScreen::class.java)
        startActivity(intent)
    }
}