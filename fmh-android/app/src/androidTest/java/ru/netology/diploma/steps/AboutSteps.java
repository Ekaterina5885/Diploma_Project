package ru.netology.diploma.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import org.hamcrest.Matcher;

public class AboutSteps {

    public static void clickButtonAbout(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonPrivacyPolicy(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .check(matches(allOf(withText("https://vhospice.org/#/privacy-policy/"), isDisplayed(), isClickable())));
    }

    public static void clickButtonTermsOfUse(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .check(matches(allOf(withText("https://vhospice.org/#/terms-of-use"), isDisplayed(), isClickable())));
    }

    public static void clickButtonBackAbout(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }
}