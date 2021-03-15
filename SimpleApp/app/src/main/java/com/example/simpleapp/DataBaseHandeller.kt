package com.example.simpleapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

var DATABASE_NAME = "Users1"
var TABLE_NAME = "User_Table"
var COL_ID = "id"
var COL_USERNAME =  "username"
var COL_EMAIL = "email"
var COL_PWD = "pwd"

public class DataBaseHandeller( var context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, 1){

    override fun onCreate(db: SQLiteDatabase?) {
        var createTable = "CREATE TABLE " + TABLE_NAME+" ("+
                COL_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COL_USERNAME+ " VARCHAR(50)," +
                COL_EMAIL+ " VARCHAR(250)," +
                COL_PWD+ " VARCHAR(20));"

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertUser(user: User){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_USERNAME, user.username)
        cv.put(COL_EMAIL, user.email)
        cv.put(COL_PWD, user.pwd)
        val result = db.insert(TABLE_NAME, null, cv)
        if (result == -1.toLong()){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        }

//        fun Cursor getAllData(){
//            val db = this.writableDatabase
//            var getQuery = "SELECT * FROM "+ TABLE_NAME +
//                    ";"
//            Cursor() res = db.raw
//        }
    }
}