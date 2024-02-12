package com.fisrtproject.myapplication.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.fisrtproject.myapplication.R
import com.fisrtproject.myapplication.data.sharedPreferencesManager

class SplashActivity : AppCompatActivity() {
    private val timersplash = 3000L //temporizador y se agrega "L" para que sea un valor long
    private lateinit var sharedPreferences: sharedPreferencesManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = sharedPreferencesManager(this)
        setContentView(R.layout.activity_splash)

        initUI()
    }

    private fun initUI() {
        setupsharedprefs()
    }


    private fun setupsharedprefs() {
        val userloged = sharedPreferences.getuserloged()
        Looper.myLooper()?.let {
            Handler(it).postDelayed(
                {


                    if (userloged) {
                        val intent = Intent(this, SegundaActivity::class.java)
                        startActivity(intent)

                    } else {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)

                    }
                }, timersplash
                )
            }


        }
    }


