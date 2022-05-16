package ru.netology.diploma.tests;

import static androidx.test.espresso.Espresso.onView;
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
import ru.netology.diploma.elements.Authorization;
import ru.netology.diploma.elements.Claims;
import ru.netology.diploma.elements.News;

@LargeTest
@RunWith(AndroidJUnit4.class)
//@RunWith(AllureAndroidJUnit4.class)

public class NewsTest {

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

//  Тест-кейсы для проведения функционального тестирования вкладки "Новости" мобильного приложения "Мобильный хоспис".

    //  TC - 40 - Просмотр новостей во вкладке "Новости" мобильного приложения "Мобильный хоспис" (Позитивный).
      @Test
    public void viewingNews() {
          SystemClock.sleep(5000);
          Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
          News.clickButtonNews(News.getNewsElementsButtonNews());
          SystemClock.sleep(2000);
          News.clickExpandNews(News.getNewsElementsButtonExpandNews());
          SystemClock.sleep(2000);
          onView(withId(R.id.news_list_swipe_refresh)).check(matches(isDisplayed()));
      }

    //  TC - 41 - Сортировка новостей во вкладке "Новости" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void newsSorting() {
          SystemClock.sleep(5000);
          Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
          News.clickButtonNews(News.getNewsElementsButtonNews());
          SystemClock.sleep(2000);
          News.clickButtonSorting(News.getNewsElementsButtonSorting());
          onView(withId(R.id.news_list_swipe_refresh)).check(matches(isDisplayed()));
      }

    //  TC - 50 - Фильтрация новостей без указания категории, во вкладке "Новости" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void filteringNewsNoCategoryPositive() {
          SystemClock.sleep(5000);
          Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
          News.clickButtonNews(News.getNewsElementsButtonNews());
          SystemClock.sleep(2000);
          News.clickButtonFilterNews(News.getNewsElementsButtonFilterNews());
          News.clickButtonTitleFilterNews(News.getNewsElementsTitleFilterNews());
          News.clickButtonCategoryFilter(News.getNewsElementsButtonCategoryFilter());
          SystemClock.sleep(2000);
          onView(withId(R.id.all_news_cards_block_constraint_layout)).check(matches(isDisplayed()));
     }

    //  TC - 52 - Фильтрация новостей, без указания категории, в определенный период времени, во вкладке "Новости" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void filteringNewsCertainPeriodTime() {
          SystemClock.sleep(5000);
          Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
          News.clickButtonNews(News.getNewsElementsButtonNews());
          SystemClock.sleep(2000);
          News.clickButtonFilterNews(News.getNewsElementsButtonFilterNews());
          News.clickButtonTitleFilterNews(News.getNewsElementsTitleFilterNews());
          News.clickButtonDateStart(News.getNewsElementsButtonDateStart());
          News.clickButtonOkDateStart(News.getNewsElementsButtonOkDateStart());
          SystemClock.sleep(2000);
          News.clickButtonDateEnd(News.getNewsElementsButtonDateEnd());
          News.clickButtonCategoryFilter(News.getNewsElementsButtonCategoryFilter());
          SystemClock.sleep(2000);
          onView(withId(R.id.all_news_cards_block_constraint_layout)).check(matches(isDisplayed()));
     }

    //  TC - 53 - Фильтрация новостей, без указания категории, в определенный период времени, во вкладке "Новости" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    public void filteringNewsCertainPeriodTimeNegative() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        News.clickButtonNews(News.getNewsElementsButtonNews());
        SystemClock.sleep(2000);
        News.clickButtonFilterNews(News.getNewsElementsButtonFilterNews());
        News.clickButtonTitleFilterNews(News.getNewsElementsTitleFilterNews());
        News.clickButtonDateStart(News.getNewsElementsButtonDateStart());
        News.clickButtonOkDateStart(News.getNewsElementsButtonOkDateStart());
        SystemClock.sleep(2000);
        News.clickButtonCategoryFilter(News.getNewsElementsButtonCategoryFilter());
        SystemClock.sleep(2000);
        News.clickButtonOkWrongMessage(News.getNewsElementsButtonOkWrongMessage());
        News.clickButtonDateStart(News.getNewsElementsButtonDateStart());
        News.clickButtonOkDateStart(News.getNewsElementsButtonOkDateStart());
        News.clickButtonDateEnd(News.getNewsElementsButtonDateEnd());
        News.clickButtonCategoryFilter(News.getNewsElementsButtonCategoryFilter());
        SystemClock.sleep(1000);
        onView(withId(R.id.all_news_cards_block_constraint_layout)).check(matches(isDisplayed()));
    }
}