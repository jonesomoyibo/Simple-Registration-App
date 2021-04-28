package com.decagon.jones.weekfivetask

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.CoreMatchers.containsString
import org.hamcrest.core.IsAnything.anything

@RunWith(AndroidJUnit4::class)
@LargeTest
class RegistrationActivityUITest {
   lateinit var  nameToBetyped:String
    lateinit var emailToBetyped:String
    lateinit var phoneNumberToBetyped:String
    lateinit var genderItemToSelect:String

    @get:Rule
    var activityRule: ActivityScenarioRule<RegistrationActivity>
            = ActivityScenarioRule(RegistrationActivity::class.java)



    //Initializes the string values to type on the TextEdit fields
    @Before
    fun initValidString() {
        // Specify a valid string.
        nameToBetyped = "Jones Omoyibo"
        emailToBetyped = "Jonesbenklins@gmail.com"
        phoneNumberToBetyped = "08161805123"
        genderItemToSelect = "Female"
    }

@Test
    fun test_Is_Registration_Activity_In_View(){

        onView(withId(R.id.main)).check(matches(isDisplayed()))

    }

    @Test
    fun test_CreateAccount_Text_Visibilty(){

        onView(withId(R.id.headerinfo)).check(matches(isDisplayed()))

    }

    @Test
    fun test_EnterYouyInfo_Text_Visibilty(){

        onView(withId(R.id.header2)).check(matches(isDisplayed()))
        onView(withId(R.id.header2)).check(matches(withText(R.string.header2)))


    }

    @Test
    fun test_Nav_To_Profile_Activity(){


        // get the name edittextview view  and perform a text typing action on it
        onView(withId(R.id.nameteditview))
            .perform(typeText(nameToBetyped), closeSoftKeyboard())

        // get the phoneNumber phoneedittextview view and perform a text typing action on it
        onView(withId(R.id.phoneeditview))
            .perform(typeText(phoneNumberToBetyped), closeSoftKeyboard())

        // get the email edittextview and perform a text typing action on it
        onView(withId(R.id.emaileditview))
            .perform(typeText(emailToBetyped), closeSoftKeyboard())

        // get the gender spinnerView and perform a click  action on it
        onView(withId(R.id.spinner)).perform(click())

        // get the array of data returned from on clicking the  spinnerView, select an item at position 2 and  perform a click  action on it
        onData(anything()).atPosition(2).perform(click())

        // get the gender spinnerView and perform a check item  action on it
        onView(withId(R.id.spinner)).check(matches(withSpinnerText(containsString( genderItemToSelect))))

        // get the signup ButtonView  and perform a click action on it
        onView(withId(R.id.signup)).perform(click())


        // get the signup ButtonView  and perform a check on it
        onView(withId(R.id.profileActivity)).check(matches(isDisplayed()))
    }

}