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

        name = findViewById(R.id.nameTextView)
        phoneNumber = findViewById(R.id.phonenumbertextview)
        emailAddress = findViewById(R.id.emailtextview)
        gender = findViewById(R.id.genderTextView)
    }


    private fun setViewValues() {
        name.text = getIntentFromCallingActivity().getStringExtra("Name")
        phoneNumber.text = getIntentFromCallingActivity().getStringExtra("phoneNumber")
        emailAddress.text = getIntentFromCallingActivity().getStringExtra("emailAddress")
        gender.text = getIntentFromCallingActivity().getStringExtra("gender")
    }

    private fun getIntentFromCallingActivity(): Intent {

        return intent
    }


}