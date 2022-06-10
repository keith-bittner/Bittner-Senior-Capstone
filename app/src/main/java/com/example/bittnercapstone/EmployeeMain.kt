package com.example.bittnercapstone

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class EmployeeMain : AppCompatActivity() {
    private lateinit var databaseRef: DatabaseReference
    lateinit var user: CurrentEmployee
    lateinit var land_msg: TextView
    lateinit var schedule_menu: Button
    lateinit var app_logout: Button
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.employee_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val user = FirebaseAuth.getInstance().currentUser
        var email: String
        user?.let {
            email = user.email.toString()
            val username = email.substringBefore("@")
            land_msg = findViewById(R.id.landing_msg)
            land_msg.setText("Welcome, $username")
        }

        schedule_menu = findViewById(R.id.schedule_button)
        schedule_menu.setOnClickListener {
            val intent = Intent(this, ScheduleMenu::class.java)
            startActivity(intent)
        }
        app_logout = findViewById(R.id.logout_button)
        app_logout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}