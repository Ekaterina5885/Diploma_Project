package ru.netology.diploma.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.doubleClick;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import org.hamcrest.Matcher;

public class NewsSteps {

    public static void clickButtonNews(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickExpandNews(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(doubleClick());
    }

    public static void clickButtonSorting(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonFilterNews(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonCategoryFilter(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonDateStart(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonOkDateStart(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }
    static String date = "30.05.2022";
    public static void clickButtonDateEnd(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(replaceText(date));
    }

    public static void clickButtonOkWrongMessage(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonButtonControlPanel(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonClickNews(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonDeleteNews(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonTitleFilterNews(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .check(matches(allOf(withText("Filter news"), isDisplayed())))
                .perform(click());
    }
}