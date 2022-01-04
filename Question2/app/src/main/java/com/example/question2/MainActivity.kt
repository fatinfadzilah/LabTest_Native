package com.example.question2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!dbExists(this, "mydata")) {
            createDB();

        }
    }
    private fun createDB() {
        val db = openOrCreateDatabase("mydata", MODE_PRIVATE, null)
        subToast("Database mydata created")
        val sqlText = "CREATE TABLE IF NOT EXISTS user" +
                "(id VARCHAR(30) PRIMARY KEY AUTOINCREMENT, " +
                "username VARCHAR(30) NOT NULL," +
                "password VARCHAR(30) NOT NULL " +
                ");"
        subToast("Table user created")
        db.execSQL(sqlText)
        var nextSQL =
            "INSERT INTO user(id, username, password) VALUES ('', 'ahmad', 'ahmad1234');"
        db.execSQL(nextSQL)
        subToast(" Data added!")
    }

    private fun dbExists(c: Context, dbName: String): Boolean {
        val dbFile: File = c.getDatabasePath(dbName)
        return dbFile.exists()
    }

    private fun subToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun GotoSecondActivity(view: View){
        val intent = Intent(this,secondactivity::class.java).apply{
        }
        subToast("Success")
        startActivity(intent)
    }
}