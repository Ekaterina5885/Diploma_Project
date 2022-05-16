package ru.netology.diploma.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.hamcrest.Matchers.allOf;

import android.view.View;

import org.hamcrest.Matcher;


public class AuthorizationSteps {

    public static void clickButton(Integer resourceId){
        onView(withId(resourceId))
                .perform(click())
                .check(matches(isDisplayed()));
    }

    public static void clickLoginField(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(replaceText("login2"), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }

    public static void clickPasswordField(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(replaceText("password2"), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }

    public static void clickButtonExit(Integer resourceId) {
        onView(withId(resourceId))
                .perform(click());
    }

    public static void clickButtonLogOut(Matcher<View> resourceId){
        onView(allOf(resourceId))
               .perform(click());
    }

    public static void TextAuthorization(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .check(matches(isDisplayed()));

    }

    public static void clickLoginEmpty(Matcher<View> resourceId) {
        onView(allOf(resourceId))
                .perform(replaceText(" "), closeSoftKeyboard());
    }

    public static void clickLoginFieldUnregisteredUser(Matcher<View> resourceId) {
        onView(allOf(resourceId))
                .perform(replaceText("login123"), closeSoftKeyboard());
    }

    public static void clickLoginFieldWithSpecialCharacters(Matcher<View> resourceId) {
        onView(allOf(resourceId))
                .perform(replaceText("@#$^&**"), closeSoftKeyboard());
    }

    public static void clickLoginFieldOneLetter(Matcher<View> resourceId) {
        onView(allOf(resourceId))
                .perform(replaceText("l"), closeSoftKeyboard());
    }

    public static void clickLoginFieldLettersOfDifferentCase(Matcher<View> resourceId) {
        onView(allOf(resourceId))
                .perform(replaceText("LoGin2"), closeSoftKeyboard());
    }

    public static void clickPasswordFieldIsEmpty(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(replaceText(" "), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }

    public static void clickPasswordFieldUnregisteredUser(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(replaceText("password123"), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }

    public static void clickPasswordFieldWithSpecialCharacters(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(replaceText("$%&(*^$"), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }

    public static void clickPasswordFieldOneLetter(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(replaceText("p"), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }

    public static void clickPasswordFieldLettersOfDifferentCase(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(replaceText("PassWord2"), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }
}