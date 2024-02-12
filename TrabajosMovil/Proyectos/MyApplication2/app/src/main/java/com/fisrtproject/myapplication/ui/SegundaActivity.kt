package com.fisrtproject.myapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fisrtproject.myapplication.databinding.ActivitySegundaBinding

class SegundaActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySegundaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Llamamos a la función para inicializar la UI
        initUI()
    }

    private fun initUI() {
        // Llamamos a la función para configurar el texto
        setupText()
    }

    private fun setupText() {
        val intent = intent
        val username = intent.getStringExtra("USERNAME")
        val password = intent.getStringExtra("PASSWORD")

            binding.textViewUsername.text = "Username: $username"
        binding.textViewPassword.text = "Password: $password"
    }


}
