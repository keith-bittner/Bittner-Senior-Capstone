package com.example.bittnercapstone

import java.io.Serializable

class ScheduleObject (
    var date: String,
    var start: String,
    var customer: String,
    var worker: String,
    var status: String ) : Serializable {

    constructor() : this("", "" , "", "", "")

    override fun toString(): String {
        return "$date $start $customer $worker $status"
    }
}