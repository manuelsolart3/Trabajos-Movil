package com.fisrtproject.myapplication.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.fisrtproject.myapplication.data.sharedPreferencesManager
import com.fisrtproject.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    //Declaramos la variable
    private lateinit var binding: ActivityMainBinding

    //Creamos una variable para la clase
    private lateinit var sharedpref: sharedPreferencesManager

    //on create es el primer metodo que se ejecuta, creamos una instancia
    override fun onCreate(savedInstanceState: Bundle?) {






        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        //Llamamos la clase y le entregamos el contexto
        sharedpref=sharedPreferencesManager(this)
        val user = sharedpref.getuser()
        Toast.makeText(this,user, Toast.LENGTH_SHORT).show()
        InitU()

    }

    private fun InitU() {
        setupOnClickListener()
    }


    private fun setupOnClickListener() {
        binding.buttonLogin.setOnClickListener {
            val username = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()


            //asi pasamos a la segunda actividad
            val intent = Intent(this, SegundaActivity::class.java)


            intent.putExtra("USERNAME", username)
            intent.putExtra("PASSWORD", password)

            //almacenamos la informacion de la BD
            sharedpref.saveUser(username)


            startActivity(intent)
        }
    }
}
