package ru.netology.diploma.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
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
import ru.netology.diploma.elements.Authorization;
import ru.netology.diploma.elements.Main;

@LargeTest
@RunWith(AndroidJUnit4.class)
//@RunWith(AllureAndroidJUnit4.class)

public class MainTest {
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

// Тест-кейсы для проведения функционального тестирования вкладки "Главная" мобильного приложения "Мобильный хоспис".

    //  TC - 12 - Переход во вкладку "Все Новости" через главное меню мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    public void ButtonAllNews(){
        SystemClock.sleep(5000);
        Main.clickButtonAllNews(Main.getMainElementsButtonAllNews());
        SystemClock.sleep(1000);
        onView(withId(R.id.news_list_swipe_refresh)).check(matches(isEnabled()));
    }

    //  TC - 13 - Переход во вкладку "Все Заявки" через главное меню мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    public void ButtonAllClaims(){
        SystemClock.sleep(5000);
        Main.clickButtonClaims(Main.getMainElementsButtonClaims());
        SystemClock.sleep(1000);
        onView(withId(R.id.claim_list_recycler_view)).check(matches(isEnabled()));
    }
}