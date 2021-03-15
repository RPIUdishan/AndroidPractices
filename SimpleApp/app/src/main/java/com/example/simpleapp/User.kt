package com.example.simpleapp

class User {

    var id : Int = 0
    var username : String = ""
    var email : String = ""
    var pwd : String = ""

    constructor(username:String, email:String, pwd:String){
        this.username = username
        this.email = email
        this.pwd = pwd
    }
}