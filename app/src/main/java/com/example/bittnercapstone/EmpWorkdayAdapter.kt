package com.example.bittnercapstone

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView

class EmpWorkdayAdapter(context:Context, mTaskList: MutableList<ScheduleObject>): BaseAdapter() {
    private val inflater:LayoutInflater = LayoutInflater.from(context)
    private var scheduledList = mTaskList
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val date = scheduledList[position].date
        val start = scheduledList[position].start
        val customer = scheduledList[position].customer
        val status = scheduledList[position].status
        val view: View
        val listRowHolder: ListRowHolder

        if (convertView == null) {
            view = inflater.inflate(R.layout.empworkday_adapter, parent, false)
            listRowHolder = ListRowHolder(view)
            view.tag = listRowHolder
        } else {
            view = convertView
            listRowHolder = view.tag as ListRowHolder
        }
        listRowHolder.scheduledDate.text = date
        listRowHolder.scheduledStart.text = start
        listRowHolder.scheduledCustomer.text = customer

        listRowHolder.scheduledCustomer.setOnClickListener {
            view.context.startActivity(Intent(view.context, ScheduleMenu::class.java))
        }

        listRowHolder.scheduledStatus.text = status
        return view


    }
    override fun getItem(index: Int): Any {
        return scheduledList[index]
    }
    override fun getItemId(index: Int): Long {
        return index.toLong()
    }
    override fun getCount(): Int {
        return scheduledList.size
    }
    private class ListRowHolder(row: View?) {
        val scheduledDate: TextView = row!!.findViewById(R.id.workday_date) as TextView
        val scheduledStart: TextView = row!!.findViewById(R.id.workday_time) as TextView
        val scheduledCustomer: Button = row!!.findViewById(R.id.workday_customer) as Button
        val scheduledStatus: TextView = row!!.findViewById(R.id.workday_status) as TextView
    }
}