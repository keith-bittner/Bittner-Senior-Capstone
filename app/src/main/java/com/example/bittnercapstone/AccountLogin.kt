package com.example.bittnercapstone

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ValueEventListener

class AccountLogin : AppCompatActivity() {
    private lateinit var databaseRef: DatabaseReference
    lateinit var user: CurrentEmployee
    private lateinit var man_username: EditText
    private lateinit var man_password: EditText
    private lateinit var login_submit: Button

    private lateinit var login_auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.account_login)

        user = CurrentEmployee()

        man_username = this.findViewById(R.id.login_username)
        man_password = findViewById(R.id.login_userpass)
        login_submit = findViewById(R.id.login_button)

        login_auth = FirebaseAuth.getInstance()

        login_submit.setOnClickListener {
            if (man_username.text.toString() != "") {
                loadUser(man_username.text.toString())
            } else {
                Toast.makeText(this, "Username box is empty!", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun loginManager() {
        val username = man_username.text.toString()
        val password = man_password.text.toString()
        login_auth.signInWithEmailAndPassword(username, password).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                val intent = Intent(this, ManagerMain::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Login failed1!", Toast.LENGTH_SHORT).show()
            }
        }
        man_username.setText("")
        man_password.setText("")
    }
    private fun loginEmployee() {

        val username = man_username.text.toString()
        val password = man_password.text.toString()
        login_auth.signInWithEmailAndPassword(username, password).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                val intent = Intent(this, EmployeeMain::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Login failed1!", Toast.LENGTH_SHORT).show()
            }
        }
        man_username.setText("")
        man_password.setText("")
    }
    private fun loadUser(email: String) {
        val domain = email.substringBefore("@")

        val path = "employees/$domain"

        databaseRef = FirebaseDatabase.getInstance().getReference(path)

        databaseRef.addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    user.email = dataSnapshot.child("email").value.toString()
                    if (email == user.email) {
                        user.firstname = dataSnapshot.child("firstname").value.toString()
                        user.ismanager = dataSnapshot.child("ismanager").value as Boolean

                        if (user.ismanager) {
                            loginManager()
                        } else {
                            loginEmployee()
                        }
                    } else {
                        Toast.makeText(this@AccountLogin, "Credentials are not valid1!", Toast.LENGTH_SHORT ).show()
                    }
                } else {
                    Toast.makeText(this@AccountLogin, "Credentials are not valid2!", Toast.LENGTH_SHORT ).show()
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}