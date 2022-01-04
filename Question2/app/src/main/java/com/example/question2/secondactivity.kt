package com.example.question2

import android.content.Intent

import android.os.Bundle
import android.widget.Button
import android.widget.EditText

import androidx.appcompat.app.AppCompatActivity

class secondactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.secondactivity)

        //retrieve data in shared preference
        val sp = this.getSharedPreferences("ahmad", MODE_PRIVATE)
        val iname = findViewById<EditText>(R.id.editUsername)
        val ipass = findViewById<EditText>(R.id.editPassword)
        iname.setText(sp.getString("username", null))
        ipass.setText(sp.getString("password", null))
    }
        override fun onPause() {
            super.onPause()
            val iname=findViewById<EditText>(R.id.editUsername)
            val ipass=findViewById<EditText>(R.id.editPassword)

            val sp =this.getSharedPreferences("ahmad", MODE_PRIVATE)
            val editor =sp.edit()
            editor.putString("name",iname.text.toString())
            editor.putString("age",ipass.text.toString())
            editor.commit() //synchonize


            val logout = findViewById<Button>(R.id.btnlogout)
            logout.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


        }
    }
}