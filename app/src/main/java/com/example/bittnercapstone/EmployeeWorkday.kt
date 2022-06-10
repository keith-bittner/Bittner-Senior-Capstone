package com.example.bittnercapstone

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.database.*

class EmployeeWorkday : AppCompatActivity() {
    private lateinit var home_button: Button
    private lateinit var scheduleTable: ListView
    private lateinit var databaseRef: DatabaseReference
    private lateinit var scheduledList: MutableList<ScheduleObject>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.schedule_menu)

        scheduleTable = findViewById(R.id.list_view)

        getSchedule()
        home_button = findViewById(R.id.emp_main_button)
        home_button.setOnClickListener {
            val intent = Intent(this, EmployeeMain::class.java)
            startActivity(intent)
        }
    }

    private fun getSchedule() {
        val path = "schedule"

        databaseRef = FirebaseDatabase.getInstance().getReference(path)

        databaseRef.addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                scheduledList.clear()
                if (dataSnapshot.exists()) {
                    for (schedule in dataSnapshot.children.iterator()) {
                        val scheduleData = ScheduleObject()
                        scheduleData.date = schedule.child("S$schedule/date").value.toString()
                        scheduleData.start = schedule.child("S$schedule/start").value.toString()
                        scheduleData.customer = schedule.child("S$schedule/customer").value.toString()
                        scheduleData.status = schedule.child("S$schedule/status").value.toString()
                        scheduledList.add(scheduleData)
                        val myadapter = EmpWorkdayAdapter(applicationContext, scheduledList)
                        scheduleTable.adapter = myadapter
                    }
                } else {
                    Toast.makeText(this@EmployeeWorkday, "You Screwed the pooch!", Toast.LENGTH_SHORT ).show()
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}