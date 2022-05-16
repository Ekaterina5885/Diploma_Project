package ru.netology.diploma.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.os.SystemClock;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.netology.diploma.elements.About;
import ru.netology.diploma.elements.Authorization;
import ru.netology.diploma.elements.Claims;

@LargeTest
@RunWith(AndroidJUnit4.class)
//@RunWith(AllureAndroidJUnit4.class)

public class AboutTest {

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void Authorization () {
        SystemClock.sleep(5000);
        try {
            Authorization.TextAuthorization(Authorization.getAuthorizationElementsTextAuthorization());
        } catch (NoMatchingViewException e) {
            return;
        }
        Authorization.TextAuthorization(Authorization.getAuthorizationElementsTextAuthorization());
        Authorization.clickLoginField(Authorization.getAuthorizationElementsLoginField());
        Authorization.clickPasswordField(Authorization.getAuthorizationElementsPasswordField());
        SystemClock.sleep(1000);
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
    }

    @After
    public void Exit () {
        SystemClock.sleep(2000);
        Authorization.clickButtonExit(Authorization.getAuthorizationElementsButtonExit());
        SystemClock.sleep(2000);
        Authorization.clickButtonLogOut(Authorization.getAuthorizationElementsButtonLogOut());
    }

//  Тест-кейсы для проведения функционального тестирования вкладки "О приложении" мобильного приложения "Мобильный хоспис".

    //  TC - 74 - Просмотр ссылки "Политика конфиденциальности" во вкладке "О приложении" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void transitionPrivacyPolicy() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        About.clickButtonAbout(About.getAboutElementsButtonAbout());
        SystemClock.sleep(2000);
        About.clickButtonPrivacyPolicy(About.getAboutElementsButtonPrivacyPolicy());
        SystemClock.sleep(1000);
        onView(withId(R.id.action_bar_root)).check(matches(isDisplayed()));
        //Выход
        pressBack();
    }

    //  TC - 75 - Просмотр ссылки "Пользовательское соглашение" во вкладке "О приложении" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void transitionTermsOfUse() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        About.clickButtonAbout(About.getAboutElementsButtonAbout());
        SystemClock.sleep(2000);
        About.clickButtonTermsOfUse(About.getAboutElementsButtonTermsOfUse());
        SystemClock.sleep(1000);
        onView(withId(R.id.action_bar_root)).check(matches(isDisplayed()));
        //Выход
        pressBack();
    }
}