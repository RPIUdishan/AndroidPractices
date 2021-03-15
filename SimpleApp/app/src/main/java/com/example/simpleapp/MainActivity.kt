package com.example.simpleapp

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var editUN = findViewById<EditText>(R.id.editUsername)
        var editEmail = findViewById<EditText>(R.id.editEmail)
        var editpwd = findViewById<EditText>(R.id.editPwd)

        var btnSubmit = findViewById<Button>(R.id.btnSubmit)
        var btnShow = findViewById<Button>(R.id.btnShow)

        var context = this

        btnSubmit.setOnClickListener(){
            Log.i("check", "Clicked")
            if(editUN.text.toString().length>0 && editEmail.text.toString().length>0 && editpwd.text.toString().length>0){
                Log.i("check", "Checked")
                var user = User(editUN.text.toString(), editEmail.text.toString(), editpwd.text.toString())
                Log.i("check", "Object Created")
                var db = DataBaseHandeller(context)
                db.insertUser(user)
                Log.i("check", "Inserted")
                Toast.makeText(context, "Successfully Inserted", Toast.LENGTH_SHORT)

            }else{
                Toast.makeText(context, "Failed", Toast.LENGTH_SHORT)
            }
        }

        btnShow.setOnClickListener(){
            var intent = Intent(this, show::class.java)
            startActivity(intent)
        }
    }




}