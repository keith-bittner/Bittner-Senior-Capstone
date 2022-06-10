package com.example.bittnercapstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val button1: Button = findViewById(R.id.main_login)
        val button2: Button = findViewById(R.id.referral)

        button1.setOnClickListener {
            val intent = Intent(this, AccountLogin::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener {
            val intent = Intent(this, ReferralForm::class.java)
            startActivity(intent)
        }
    }
}