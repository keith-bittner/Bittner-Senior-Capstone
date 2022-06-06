package com.example.bittnercapstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1: Button = findViewById(R.id.main_login)

        button1.setOnClickListener {
            val intent = Intent(this, AccountLogin::class.java)
            startActivity(intent)
        }
    }
}