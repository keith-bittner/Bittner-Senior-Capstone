package com.example.bittnercapstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TableLayout

class EmployeeWorkday : AppCompatActivity() {
    lateinit var home_button: Button
    private lateinit var scheduleTable: TableLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.schedule_menu)

        home_button = findViewById(R.id.emp_main_button)
        home_button.setOnClickListener {
            val intent = Intent(this, EmployeeMain::class.java)
            startActivity(intent)
        }

        fun loadScheduleData() {

            val path = "schedule/$domain"
        }

    }
}