package com.example.bittnercapstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ScheduleMenu : AppCompatActivity() {
    lateinit var day_button: Button
    lateinit var home_button: Button
    lateinit var app_logout: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.schedule_menu)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        day_button = findViewById(R.id.workday_button)
        day_button.setOnClickListener {
            val intent = Intent(this, EmployeeWorkday::class.java)
            startActivity(intent)
        }

        home_button = findViewById(R.id.emp_main_button)
        home_button.setOnClickListener {
            val intent = Intent(this, EmployeeMain::class.java)
            startActivity(intent)
        }
        app_logout = findViewById(R.id.logout_button)
        app_logout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}