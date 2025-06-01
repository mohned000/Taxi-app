package com.example.taxiapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val driverButton: Button = findViewById(R.id.driverButton)
        val passengerButton: Button = findViewById(R.id.passengerButton)

        driverButton.setOnClickListener {
            startActivity(Intent(this, DriverRegistrationActivity::class.java))
        }

        passengerButton.setOnClickListener {
            startActivity(Intent(this, PassengerRegistrationActivity::class.java))
        }
    }
}