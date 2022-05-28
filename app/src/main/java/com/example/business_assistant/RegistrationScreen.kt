package com.example.business_assistant

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class RegistrationScreen : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var password:EditText
    private  lateinit var repitPassword:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration_screen)

        supportActionBar?.setDisplayHomeAsUpEnabled(true);

        email = findViewById(R.id.editTextTextEmailAddress)
        password = findViewById(R.id.editTextTextPassword)
        repitPassword = findViewById(R.id.editTextTextPasswordRepit)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==android.R.id.home) finish()
        return true;
    }

    fun createAccount(view: View) {
        if(!email.text.isNullOrEmpty()&&!password.text.isNullOrEmpty()&&!repitPassword.text.isNullOrEmpty())
        {
            if(password.text.toString()==repitPassword.text.toString())
            {
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(applicationContext,"Регистрация прошла успешно.",Toast.LENGTH_SHORT).show()
                        }
                    }
            }
            else
                Toast.makeText(applicationContext,"Пароли не совподают.",Toast.LENGTH_SHORT).show()
        }
        else
            Toast.makeText(applicationContext,"Заполните поля.",Toast.LENGTH_SHORT).show()
    }
}