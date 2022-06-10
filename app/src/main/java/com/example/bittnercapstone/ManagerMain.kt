package com.example.bittnercapstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class ManagerMain : AppCompatActivity() {
    //lateinit var man_emp: Button
    //lateinit var new_emp: Button
    //lateinit var man_cust: Button
    //lateinit var new_cust: Button
    //lateinit var man_schedule: Button
    lateinit var emp_view: Button
    lateinit var man_logout: Button
    lateinit var land_msg: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.manager_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val user = FirebaseAuth.getInstance().currentUser
        var email: String
        user?.let {
            email = user.email.toString()
            val username = email.substringBefore("@")
            land_msg = findViewById(R.id.landing_msg)
            land_msg.setText("Welcome, $username")
        }

        emp_view = findViewById(R.id.emp_view_button)
        emp_view.setOnClickListener {
            val intent = Intent(this, EmployeeMain::class.java)
            startActivity(intent)
        }
        man_logout = findViewById(R.id.logout_button)
        man_logout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}