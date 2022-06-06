package com.example.bittnercapstone

import java.io.Serializable

class CurrentEmployee(
    var empid: String,
    var userid: String,
    var lastname: String,
    var firstname: String,
    var username: String,
    var ismanager: Boolean,
    var email: String ) : Serializable{

    constructor() : this("","","", "", "", false, "")

    override fun toString(): String {
        return "$empid $userid $lastname $firstname $username $ismanager $email"
    }
}