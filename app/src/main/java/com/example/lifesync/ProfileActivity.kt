package com.example.lifesync

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var editTextNombres : EditText
    private lateinit var editTextApellidos : EditText
    private lateinit var editTextCorreo: EditText
    private lateinit var editTextTelefono: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }
}