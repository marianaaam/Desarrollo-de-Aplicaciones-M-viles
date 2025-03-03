package com.example.lifesync

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var editTextNombres : EditText
    private lateinit var editTextApellidos : EditText
    private lateinit var editTextCorreo: EditText
    private lateinit var editTextTelefono: EditText
    private lateinit var buttonEditProfile: Button

    private lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        editTextNombres = findViewById(R.id.et_names)
        editTextApellidos = findViewById(R.id.et_surnames)
        editTextTelefono = findViewById(R.id.et_phone)
        editTextCorreo = findViewById(R.id.et_email)
        buttonEditProfile = findViewById(R.id.b_editProfile)

        sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)

        loadProfileData()
        buttonEditProfile.setOnClickListener {
            saveProfileData()
        }
    }

    private fun loadProfileData() {
        // Recuperar los datos de SharedPreferences
        val nombres = sharedPreferences.getString("nombres", "")
        val apellidos = sharedPreferences.getString("apellidos", "")
        val correo = sharedPreferences.getString("correo", "")
        val telefono = sharedPreferences.getString("telefono", "")


        editTextNombres.setText(nombres)
        editTextApellidos.setText(apellidos)
        editTextCorreo.setText(correo)
        editTextTelefono.setText(telefono)
    }

    private fun saveProfileData() {

        val nombres = editTextNombres.text.toString()
        val apellidos = editTextApellidos.text.toString()
        val correo = editTextCorreo.text.toString()
        val telefono = editTextTelefono.text.toString()

        val editor = sharedPreferences.edit()
        editor.putString("nombres", nombres)
        editor.putString("apellidos", apellidos)
        editor.putString("correo", correo)
        editor.putString("telefono", telefono)
        editor.apply()

        Toast.makeText(this, "Perfil actualizado con éxito", Toast.LENGTH_SHORT).show()
    }
}