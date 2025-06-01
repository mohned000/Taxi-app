package com.example.taxiapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class RouteSelectionActivity : AppCompatActivity() {
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_route_selection)

        db = FirebaseFirestore.getInstance()

        val routesListView: ListView = findViewById(R.id.routesListView)

        db.collection("routes").get().addOnSuccessListener { result ->
            val routes = mutableListOf<String>()
            for (document in result) {
                val routeName = document.getString("name")
                if (routeName != null) {
                    routes.add(routeName)
                }
            }

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, routes)
            routesListView.adapter = adapter

            routesListView.setOnItemClickListener { _, _, position, _ ->
                val selectedRoute = routes[position]
                Toast.makeText(this, "تم اختيار المسار: $selectedRoute", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, DriverSelectionActivity::class.java)
                intent.putExtra("route", selectedRoute)
                startActivity(intent)
            }
        }.addOnFailureListener {
            Toast.makeText(this, "حدث خطأ أثناء تحميل المسارات", Toast.LENGTH_SHORT).show()
        }
    }
}