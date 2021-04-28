package com.decagon.jones.weekfivetask

import java.util.regex.Matcher
import java.util.regex.Pattern

class ViewValidator {


    companion object {

        private val NAME_PATTERN = "[a-zA-Z]{3,}\\s[a-zA-Z]{3,}"
        private val EMAIL_PATTERN =  "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}"
        private val PHONE_NUMBER_PATTERN = "^(234|0)(80|90|81|70)[0-9]{8}"


        fun nameValidator(name: String): Boolean {

            return matcher(NAME_PATTERN,name)
        }



        fun emailValidator(email: String): Boolean {
            return matcher(EMAIL_PATTERN,email)
        }



        fun spinnerValidator(gender: String): Boolean {
          return gender == "Gender"
        }


        fun phoneNumberValidator(phoneNumber: String): Boolean {
            return matcher(PHONE_NUMBER_PATTERN,phoneNumber)
        }


        private fun matcher(pattern: String,stringToMatch:String): Boolean {

            return Pattern.compile(pattern).matcher(stringToMatch).matches()
        }
    }




}