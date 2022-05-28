package com.example.business_assistant

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class AuthorizationScreen : AppCompatActivity() {
    private lateinit var email:EditText
    private lateinit var password:EditText
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.authorization_screen)


        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        email=findViewById(R.id.AuthEmailAddress)
        password=findViewById(R.id.AuthTextPassword)
    }

    fun goToRegistration(view: View) {
        val intent = Intent(this, RegistrationScreen::class.java)
        startActivity(intent)
    }

    fun signInApp(view: View) {
        if(!email.text.isNullOrEmpty()&&!password.text.isNullOrEmpty())
        {
            auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                    }
                }
        }
        else
            Toast.makeText(applicationContext,"Заполните поля.", Toast.LENGTH_SHORT).show()
    }
}