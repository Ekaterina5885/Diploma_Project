package ru.netology.diploma.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;

import static org.hamcrest.Matchers.allOf;

import android.os.SystemClock;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.ui.AppActivity;
import ru.netology.diploma.elements.Authorization;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)


public class AuthorizationTest {
    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

// Тест-кейсы для проведения функционального тестирования вкладки "Авторизация" мобильного приложения "Мобильный хоспис".

    //  TC - 1 - Авторизация в мобильном приложении "Мобильный хоспис"(Позитивный).
    @Test
    public void successfulAuthorization () {
        SystemClock.sleep(5000);
        Authorization.TextAuthorization(Authorization.getAuthorizationElementsTextAuthorization());
        Authorization.clickLoginField(Authorization.getAuthorizationElementsLoginField());
        Authorization.clickPasswordField(Authorization.getAuthorizationElementsPasswordField());
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        Authorization.clickButtonExit(Authorization.getAuthorizationElementsButtonExit());
        Authorization.clickButtonLogOut(Authorization.getAuthorizationElementsButtonLogOut());
    }

    //  TC - 2 - Поле "Логин" пустое, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
    @Test
    public void loginFieldIsEmpty () {
        SystemClock.sleep(5000);
        Authorization.TextAuthorization(Authorization.getAuthorizationElementsTextAuthorization());
        Authorization.clickLoginEmpty(Authorization.getAuthorizationElementsLoginField());
        Authorization.clickPasswordField(Authorization.getAuthorizationElementsPasswordField());
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Login and password cannot be empty"), isDisplayed()));
    }

    //  TC - 3 - Поле "Логин" заполнено данными незарегистрированного пользователя, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
    @Test
    public void loginFieldUnregisteredUser () {
        SystemClock.sleep(5000);
        Authorization.TextAuthorization(Authorization.getAuthorizationElementsTextAuthorization());
        Authorization.clickLoginFieldUnregisteredUser(Authorization.getAuthorizationElementsLoginField());
        Authorization.clickPasswordField(Authorization.getAuthorizationElementsPasswordField());
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    //  TC - 4 - Поле "Логин" состоит из спецсимволов, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
    @Test
    public void LoginFieldWithSpecialCharacters () {
        SystemClock.sleep(5000);
        Authorization.TextAuthorization(Authorization.getAuthorizationElementsTextAuthorization());
        Authorization.clickLoginFieldWithSpecialCharacters(Authorization.getAuthorizationElementsLoginField());
        Authorization.clickPasswordField(Authorization.getAuthorizationElementsPasswordField());
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    //  TC - 5 - Поле "Логин" состоит из одного символа, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
    @Test
    public void LoginFieldOneLetter () {
        SystemClock.sleep(5000);
        Authorization.TextAuthorization(Authorization.getAuthorizationElementsTextAuthorization());
        Authorization.clickLoginFieldOneLetter(Authorization.getAuthorizationElementsLoginField());
        Authorization.clickPasswordField(Authorization.getAuthorizationElementsPasswordField());
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    //  TC - 6 - Поле "Логин" состоит из букв разного регистра, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
    @Test
    public void LoginFieldLettersOfDifferentCase () {
        SystemClock.sleep(5000);
        Authorization.TextAuthorization(Authorization.getAuthorizationElementsTextAuthorization());
        Authorization.clickLoginFieldLettersOfDifferentCase(Authorization.getAuthorizationElementsLoginField());
        Authorization.clickPasswordField(Authorization.getAuthorizationElementsPasswordField());
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    //  TC - 7 - Поле "Пароль" пустое, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
    @Test
    public void PasswordFieldIsEmpty () {
        SystemClock.sleep(5000);
        Authorization.TextAuthorization(Authorization.getAuthorizationElementsTextAuthorization());
        Authorization.clickLoginField(Authorization.getAuthorizationElementsLoginField());
        Authorization.clickPasswordFieldIsEmpty(Authorization.getAuthorizationElementsPasswordField());
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    //  TC - 8 - Поле "Пароль" заполнено данными незарегистрированного пользователя, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
    @Test
    public void PasswordFieldUnregisteredUser () {
        SystemClock.sleep(5000);
        Authorization.TextAuthorization(Authorization.getAuthorizationElementsTextAuthorization());
        Authorization.clickLoginField(Authorization.getAuthorizationElementsLoginField());
        Authorization.clickPasswordFieldUnregisteredUser(Authorization.getAuthorizationElementsPasswordField());
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    //  TC - 9 - Поле "Пароль" состоит из спецсимволов, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
    @Test
    public void PasswordFieldWithSpecialCharacters () {
        SystemClock.sleep(5000);
        Authorization.TextAuthorization(Authorization.getAuthorizationElementsTextAuthorization());
        Authorization.clickLoginField(Authorization.getAuthorizationElementsLoginField());
        Authorization.clickPasswordFieldWithSpecialCharacters(Authorization.getAuthorizationElementsPasswordField());
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    //  TC - 10 - Поле "Пароль" состоит из одного символа, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
    @Test
    public void PasswordFieldOneLetter () {
        SystemClock.sleep(5000);
        Authorization.TextAuthorization(Authorization.getAuthorizationElementsTextAuthorization());
        Authorization.clickLoginField(Authorization.getAuthorizationElementsLoginField());
        Authorization.clickPasswordFieldOneLetter(Authorization.getAuthorizationElementsPasswordField());
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    //  TC - 11 - Поле "Пароль" состоит из букв разного регистра, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
    @Test
    public void PasswordFieldLettersOfDifferentCase () {
        SystemClock.sleep(5000);
        Authorization.TextAuthorization(Authorization.getAuthorizationElementsTextAuthorization());
        Authorization.clickLoginField(Authorization.getAuthorizationElementsLoginField());
        Authorization.clickPasswordFieldLettersOfDifferentCase(Authorization.getAuthorizationElementsPasswordField());
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }
}