package com.example.email

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etEmail:EditText=findViewById(R.id.etEmail)
        val etSubject:EditText=findViewById(R.id.etSubject)
        val etMsg:EditText=findViewById(R.id.etMsg)
        val btSnd: Button =findViewById(R.id.btSnd)
        btSnd.setOnClickListener {
            val email = etEmail.text.toString()
            val subject=etSubject.text.toString()
            val message = etMsg.text.toString()
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL,arrayOf(email))
            intent.putExtra(Intent.EXTRA_SUBJECT,subject)
            intent.putExtra(Intent.EXTRA_TEXT,message)
            intent.type="message/rfc822"
            startActivity(Intent.createChooser(intent,"Choose a client"))//to choose the list of email providers/applications on the device
        }
    }
}