package com.example.taxiapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DriverDashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_dashboard)

        val passengersCount: TextView = findViewById(R.id.passengersCount)
        val increaseButton: Button = findViewById(R.id.increaseButton)
        val decreaseButton: Button = findViewById(R.id.decreaseButton)

        var count = 0
        passengersCount.text = count.toString()

        increaseButton.setOnClickListener {
            count++
            passengersCount.text = count.toString()
        }

        decreaseButton.setOnClickListener {
            if (count > 0) {
                count--
                passengersCount.text = count.toString()
            }
        }
    }
}