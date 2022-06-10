package com.example.bittnercapstone

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class CustomerJob : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.customer_job)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }
}