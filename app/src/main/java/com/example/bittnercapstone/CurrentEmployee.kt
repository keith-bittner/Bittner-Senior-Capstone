package com.example.bittnercapstone

import java.io.Serializable

class CurrentEmployee(
    var userid: String,
    var lastname: String,
    var firstname: String,
    var username: String,
    var ismanager: Boolean,
    var email: String ) : Serializable{

    constructor() : this("","","", "", false, "")

    override fun toString(): String {
        return "$userid $lastname $firstname $username $ismanager $email"
    }
}