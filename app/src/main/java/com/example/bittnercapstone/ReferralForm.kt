package com.example.bittnercapstone


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


class ReferralForm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.referral_form)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }
}