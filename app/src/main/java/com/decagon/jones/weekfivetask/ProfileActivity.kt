package com.decagon.jones.weekfivetask

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var name: TextView
    private lateinit var phoneNumber: TextView
    private lateinit var emailAddress: TextView
    private lateinit var gender: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initViews()
        setViewValues()


    }

    private fun initViews() {

        name = findViewById<TextView>(R.id.nameTextView)
        phoneNumber = findViewById<TextView>(R.id.phonenumbertextview)
        emailAddress = findViewById<TextView>(R.id.emailtextview)
        gender = findViewById<TextView>(R.id.genderTextView)
    }


    private fun setViewValues() {
        name.setText( getIntentFromCallingActivity().getStringExtra("Name"))
        phoneNumber.setText( getIntentFromCallingActivity().getStringExtra("phoneNumber"))
        emailAddress.setText( getIntentFromCallingActivity().getStringExtra("emailAddress"))
        gender.setText(getIntentFromCallingActivity().getStringExtra("gender"))
    }

    private fun getIntentFromCallingActivity(): Intent {

        return getIntent()
    }


}