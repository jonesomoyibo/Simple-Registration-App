package com.decagon.jones.weekfivetask

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class RegistrationActivity : AppCompatActivity() {

    private lateinit var nameView: TextInputEditText
    private lateinit var phoneNumberView: TextInputEditText
    private lateinit var emailView: TextInputEditText
    private lateinit var signUpButton: Button
    private lateinit var spinner: Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        initializeViews()


    }


    private fun initializeViews() {
        spinner = findViewById(R.id.spinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.Gender_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }


        nameView = findViewById<TextInputEditText>(R.id.nameteditview)
        phoneNumberView = findViewById<TextInputEditText>(R.id.phoneeditview)
        emailView = findViewById<TextInputEditText>(R.id.emaileditview)



        signUpButton = findViewById<Button>(R.id.signup).apply {
            setOnClickListener {
                if (validateViews()) {
                    val intent: Intent =
                        Intent(this@RegistrationActivity, ProfileActivity::class.java)
                    intent.apply {
                        putExtra(
                            "Name", nameView.text.toString()
                        )
                        putExtra("phoneNumber", phoneNumberView.text.toString())
                        putExtra("emailAddress", emailView.text.toString())
                        putExtra("gender", spinner.selectedItem.toString())

                    }
                    startActivity(intent)
                }
            }

        }

    }


    private fun validateViews(): Boolean {

        var isViewValidated: Boolean = true
        if (!ViewValidator.nameValidator(nameView.text.toString())) {
            nameView.error = "Invalid Input"
            isViewValidated = false
        }
        if (!ViewValidator.phoneNumberValidator(phoneNumberView.text.toString().trim())) {
            phoneNumberView.error = "Invalid Number format or Inputs"
            isViewValidated = false
        }
        if (!ViewValidator.emailValidator(emailView.text.toString().trim())) {
            emailView.error = "Invalid Email format"
            isViewValidated = false
        }
        if (ViewValidator.spinnerValidator(spinner.selectedItem.toString())) {
            Toast.makeText(
                applicationContext,
                "You havent selected your gender",
                Toast.LENGTH_SHORT
            ).apply {
                show()
                isViewValidated = false
            }

        }
        return isViewValidated
    }

}