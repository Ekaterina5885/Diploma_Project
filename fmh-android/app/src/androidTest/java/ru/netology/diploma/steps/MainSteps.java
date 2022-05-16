package ru.netology.diploma.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;

import static org.hamcrest.Matchers.allOf;
import static ru.netology.diploma.util.Util.nestedScrollTo;

import android.view.View;

import org.hamcrest.Matcher;

public class MainSteps {

    public static void clickButtonAllNews(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonMainMenu(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonClaims(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(nestedScrollTo())
                .perform(click());
    }
}