package com.example.android.testing.espresso.BasicSample;
import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testChangeTextButton() {
        Espresso.onView(withId(R.id.editTextUserInput)).perform(typeText("123"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.changeTextBt)).perform(click());
        Espresso.onView(withId(R.id.textToBeChanged)).check(matches(withText("123")));
    }

    @Test
    public void testOpenActivityAndChangeTextButton() {
        Espresso.onView(withId(R.id.editTextUserInput)).perform(typeText("123"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.activityChangeTextBtn)).perform(click());
        Espresso.onView(withId(R.id.show_text_view)).check(matches(withText("123")));
    }

    @Test
    public void testEmptyInputAndChangeTextButton() {
        Espresso.onView(withId(R.id.changeTextBt)).perform(click());
        Espresso.onView(withId(R.id.textToBeChanged)).check(matches(withText("")));
    }

    @Test
    public void testEmptyInputOpenActivityAndChangeTextButton() {
        Espresso.onView(withId(R.id.activityChangeTextBtn)).perform(click());
        Espresso.onView(withId(R.id.show_text_view)).check(matches(withText("")));
    }

    @Test
    public void testInvalidInputAndChangeTextButton() {
        Espresso.onView(withId(R.id.editTextUserInput)).perform(typeText("abcdef"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.changeTextBt)).perform(click());
        Espresso.onView(withId(R.id.textToBeChanged)).check(matches(withText("abcdef")));
    }

    @Test
    public void testInvalidInputOpenActivityAndChangeTextButton() {
        Espresso.onView(withId(R.id.editTextUserInput)).perform(typeText("abcdef"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.activityChangeTextBtn)).perform(click());
        Espresso.onView(withId(R.id.show_text_view)).check(matches(withText("abcdef")));
    }
}
