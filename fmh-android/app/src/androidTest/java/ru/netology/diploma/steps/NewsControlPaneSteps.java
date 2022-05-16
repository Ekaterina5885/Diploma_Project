package ru.netology.diploma.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import org.hamcrest.Matcher;

public class NewsControlPaneSteps {

    public static void clickButtonControlPanel(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonSorting(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonDeleteNews(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickClickNews(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickOkDeleteNews(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickRemoveCheckBoxNotActive(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonEditNews(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonTitleNewsControlPanel(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(clearText(), replaceText("Отредактированный текст новости"), closeSoftKeyboard());
    }

    public static void clickButtonSaveEditingNews(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonSwitcher(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickFilterNewsControlPanel(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonFilterNewsControlPanel(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickRemoveCheckBoxActive(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickAddNews(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonCategoryCreatingNews(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonCategoryCreatingNew(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click(),replaceText("День рождения"), closeSoftKeyboard());
    }

    public static void clickButtonCategoryCreatingNewsEmpty(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click(), replaceText("Собственное название категории"), closeSoftKeyboard());
    }

    public static void clickButtonCategoryCreatingNewsNumbers(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click(), replaceText("123456"), closeSoftKeyboard());
    }

    public static void clickButtonCategoryCreatingCharacters(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click(), replaceText("@#$%^&**"), closeSoftKeyboard());
    }

    public static void clickButtonTitleCreatingNews(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click(), clearText(), replaceText("Главные новости сегодня"), closeSoftKeyboard());
    }

    public static void clickButtonDateCreatingNews(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    static String nextYear = "30.05.2023";
    public static void clickButtonDateCreatingNextDate(Matcher<View> resourceId){
                  onView(allOf(resourceId))
                .perform(replaceText(nextYear));
    }

    public static void clickButtonOkDateCreatingNews(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonTimeCreatingNews(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickDescriptionCreatingNews(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(replaceText("Новое объявление"), closeSoftKeyboard());
    }

    public static void clickButtonOkTimeCreatingNews(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonSaveCreatingNews(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(scrollTo(), click());
    }
}