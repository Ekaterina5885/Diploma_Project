package ru.netology.diploma.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import org.hamcrest.Matcher;

public class ClaimsSteps {

    public static void clickButtonMainMenu(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonClaims(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonFilter(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickRemoveCheckBoxOpen(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonOk(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickRemoveCheckBoxInProgress(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickCheckBoxExecuted(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickCheckBoxCancelled(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonAddClaim(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickTitleField(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(replaceText("Осмотр"), closeSoftKeyboard());
    }

    public static void clickCheckBoxExecutorField(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(replaceText("Смирнов Николай Петрович"), closeSoftKeyboard());
    }

    public static void clickDateField(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonOkDate(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickTimeField(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonOkTime(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickDescriptionField(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(replaceText("Срочный осмотр"), closeSoftKeyboard());
    }

    public static void clickButtonSave(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonOkError(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonCancelClaim(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }
    public static void clickButtonOkNotification(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickTitleFieldOneCharacter(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(replaceText("1"), closeSoftKeyboard());
    }

    public static void clickTitleFieldMaximumCharacters(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(replaceText("123456789АБВГДЕЖЗИКЛМНОПРСТУФХЦЧШЩЭЮЯ1234567891011"), closeSoftKeyboard());
    }

    public static void clickExecutorFieldConsistsLettersAndNumbers(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(replaceText("И123ванов И456ванович И789ванов"), closeSoftKeyboard());
    }

    public static void clickExecutorFieldOtherData(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(replaceText("Иванов Иванович Иванов"), closeSoftKeyboard());
    }

    public static void clickExecutorFieldSpecialCharacters(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(replaceText("@#$$%%^&**"), closeSoftKeyboard());
    }


    static String nextYear = "30.05.2023";
    public static void clickDateFieldNextYear(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(replaceText(nextYear));
    }

    public static void clickOpenClaim(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickEditClaim(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickEditClaimStatusOpen(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(clearText(),replaceText("Редактирование заявки, находящаяся в статусе Открыта"),
                closeSoftKeyboard());;
    }

    public static void clickButtonAddComment(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickCommentField(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(clearText(), replaceText("Новый комментарий"), closeSoftKeyboard());
    }

    public static void clickButtonEditComment(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonSettings(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonTakeToWork(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }

    public static void clickButtonCancel(Matcher<View> resourceId){
        onView(allOf(resourceId))
                .perform(click());
    }
}