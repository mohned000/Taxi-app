package com.example.taxiapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class PassengerRegistrationActivity : AppCompatActivity() {
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passenger_registration)

        db = FirebaseFirestore.getInstance()

        val nameField: EditText = findViewById(R.id.nameField)
        val phoneField: EditText = findViewById(R.id.phoneField)
        val whatsappField: EditText = findViewById(R.id.whatsappField)
        val registerButton: Button = findViewById(R.id.registerButton)

        registerButton.setOnClickListener {
            val name = nameField.text.toString()
            val phone = phoneField.text.toString()
            val whatsapp = whatsappField.text.toString()

            if (name.isNotEmpty() && phone.isNotEmpty() && whatsapp.isNotEmpty()) {
                val passengerData = hashMapOf(
                    "name" to name,
                    "phone" to phone,
                    "whatsapp" to whatsapp,
                    "type" to "Passenger"
                )

                db.collection("passengers").add(passengerData).addOnSuccessListener {
                    Toast.makeText(this, "تم التسجيل بنجاح!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, RouteSelectionActivity::class.java))
                }.addOnFailureListener {
                    Toast.makeText(this, "حدث خطأ أثناء التسجيل", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "يرجى إدخال جميع البيانات!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}