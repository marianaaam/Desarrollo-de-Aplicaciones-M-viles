package com.example.lifesync

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RecoverPasswordActivity : AppCompatActivity (){

    private lateinit var EditTextEmail: EditText
    private lateinit var Btcorreo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recover_password)

        EditTextEmail = findViewById(R.id.ed_email)
        Btcorreo = findViewById(R.id.bt_instructions)

        Btcorreo.setOnClickListener {
            val email = EditTextEmail.text.toString().trim()

            if (email.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa tu correo electrónico", Toast.LENGTH_SHORT).show()
            } else {
                if (checkEmailExists(email)) {
                    Toast.makeText(this, "Se han enviado las instrucciones a $email", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "El correo electrónico no existe", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun checkEmailExists(email: String): Boolean {
        val sharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE)
        val savedEmail = sharedPreferences.getString("email", null)
        return savedEmail == email
    }
}