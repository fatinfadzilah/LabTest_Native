package com.example.question1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    val web = findViewById<EditText>(R.id.EditText1)
    var add_web: String = web.getText().toString()
    fun getUrlFromIntent(view: View) {
            //val url = "http://www.google.com"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(add_web)
            startActivity(intent)
    }

    val call = findViewById<EditText>(R.id.EditText2)
    var phone_number: String = call.getText().toString()
    fun call(view: View) {
        val dialIntent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone_number))
        startActivity(dialIntent)
    }

}



