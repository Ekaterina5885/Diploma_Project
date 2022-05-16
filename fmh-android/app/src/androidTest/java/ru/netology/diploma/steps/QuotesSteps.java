package ru.netology.diploma.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import android.view.View;
import org.hamcrest.Matcher;

public class QuotesSteps {

    public static void clickButtonThematicQuote(Matcher<View> resourceId){
        onView(allOf(resourceId))
                 .perform(click());
    }

    public static void clickButtonExpandThematicQuote(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickTitleThematicQuote(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .check(matches(allOf(withText("Love is all"), isDisplayed())));
    }

    public static void clickDescriptionThematicQuote(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .check(matches(isDisplayed()));
    }
}