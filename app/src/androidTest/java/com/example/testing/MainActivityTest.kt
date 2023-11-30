package com.example.testing

import androidx.test.espresso.Espresso
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var mActivityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testChangeTextButton() {
        Espresso.onView(withId(R.id.editTextUserInput)).perform(typeText("123"), closeSoftKeyboard())
        Espresso.onView(withId(R.id.changeTextBt)).perform(click())
        Espresso.onView(withId(R.id.textToBeChanged)).check(matches(withText("123")))
    }

    @Test
    fun testOpenActivityAndChangeTextButton() {
        Espresso.onView(withId(R.id.editTextUserInput)).perform(typeText("123"), closeSoftKeyboard())
        Espresso.onView(withId(R.id.activityChangeTextBtn)).perform(click())
        Espresso.onView(withId(R.id.show_text_view)).check(matches(withText("123")))
    }

    @Test
    fun testEmptyInputAndChangeTextButton() {
        Espresso.onView(withId(R.id.changeTextBt)).perform(click())
        Espresso.onView(withId(R.id.textToBeChanged)).check(matches(withText("")))
    }

    @Test
    fun testEmptyInputOpenActivityAndChangeTextButton() {
        Espresso.onView(withId(R.id.activityChangeTextBtn)).perform(click())
        Espresso.onView(withId(R.id.show_text_view)).check(matches(withText("")))
    }

    @Test
    fun testInvalidInputAndChangeTextButton() {
        Espresso.onView(withId(R.id.editTextUserInput)).perform(typeText("abcdef"), closeSoftKeyboard())
        Espresso.onView(withId(R.id.changeTextBt)).perform(click())
        Espresso.onView(withId(R.id.textToBeChanged)).check(matches(withText("abcdef")))
    }

    @Test
    fun testInvalidInputOpenActivityAndChangeTextButton() {
        Espresso.onView(withId(R.id.editTextUserInput)).perform(typeText("abcdef"), closeSoftKeyboard())
        Espresso.onView(withId(R.id.activityChangeTextBtn)).perform(click())
        Espresso.onView(withId(R.id.show_text_view)).check(matches(withText("abcdef")))
    }
}
