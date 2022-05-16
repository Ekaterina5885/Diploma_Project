package ru.netology.diploma.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import static ru.netology.diploma.util.Util.withIndex;

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
import ru.netology.diploma.elements.NewsControlPanel;

@LargeTest
@RunWith(AndroidJUnit4.class)
//@RunWith(AllureAndroidJUnit4.class)

public class NewsControlPaneTest {

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

// Тест-кейсы для проведения функционального тестирования "Панели Управления Новостей" мобильного приложения "Мобильный хоспис".

    //  TC - 54 - Сортировка новостей во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void sortingNewsControlPanel() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        News.clickButtonNews(News.getNewsElementsButtonNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonControlPanel(NewsControlPanel.getNewsControlPanelElementsButtonControlPanel());
        NewsControlPanel.clickButtonSorting(NewsControlPanel.getNewsControlPanelElementsButtonSorting());
        SystemClock.sleep(1000);
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()));
    }

    //  TC - 55 - Просмотр новостей во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void viewingNewsControlPanel() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        News.clickButtonNews(News.getNewsElementsButtonNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonControlPanel(NewsControlPanel.getNewsControlPanelElementsButtonControlPanel());
        NewsControlPanel.clickClickNews(NewsControlPanel.getNewsControlPanelElementsButtonClickNews());
        SystemClock.sleep(1000);
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()));
    }

    //  TC - 56 - Удаление активной новости во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void deletingActiveNews() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        News.clickButtonNews(News.getNewsElementsButtonNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonControlPanel(NewsControlPanel.getNewsControlPanelElementsButtonControlPanel());
        NewsControlPanel.clickClickNews(NewsControlPanel.getNewsControlPanelElementsButtonClickNews());
        NewsControlPanel.clickButtonDeleteNews(NewsControlPanel.getNewsControlPanelElementsButtonDeleteNews());
        NewsControlPanel.clickOkDeleteNews(NewsControlPanel.getNewsControlPanelElementsButtonOkDeleteNews());
        SystemClock.sleep(1000);
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()));
    }

    //  TC - 57 - Редактирование новости во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void editNewsControlPanel() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        News.clickButtonNews(News.getNewsElementsButtonNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonControlPanel(NewsControlPanel.getNewsControlPanelElementsButtonControlPanel());
        NewsControlPanel.clickClickNews(NewsControlPanel.getNewsControlPanelElementsButtonClickNews());
        NewsControlPanel.clickButtonEditNews(NewsControlPanel.getNewsControlPanelElementsButtonEditNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonTitleNewsControlPanel(NewsControlPanel.getNewsControlPanelElementsButtonTitleNewsControlPanel());
        onView(withId(android.R.id.content)).perform(swipeUp());
        SystemClock.sleep(1000);
        NewsControlPanel.clickButtonSaveEditingNews(NewsControlPanel.getNewsControlPanelElementsButtonSaveEditingNews());
        SystemClock.sleep(2000);
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()));
    }

    //  TC - 58 - Смена статуса новости, находящаяся в статусе "АКТИВНА" на статус "НЕ АКТИВНА", во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void statusChangeNews() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        News.clickButtonNews(News.getNewsElementsButtonNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonControlPanel(NewsControlPanel.getNewsControlPanelElementsButtonControlPanel());
        NewsControlPanel.clickClickNews(NewsControlPanel.getNewsControlPanelElementsButtonClickNews());
        NewsControlPanel.clickButtonEditNews(NewsControlPanel.getNewsControlPanelElementsButtonEditNews());
        NewsControlPanel.clickButtonSwitcher(NewsControlPanel.getNewsControlPanelElementsButtonSwitcher());
        SystemClock.sleep(2000);
        onView(withId(android.R.id.content)).perform(swipeUp());
        onView(withId(R.id.switcher))
                .check(matches(withText("Not active")))
                .check(matches(isDisplayed()));
        onView(withId(android.R.id.content)).perform(swipeDown());
        NewsControlPanel.clickButtonSaveEditingNews(NewsControlPanel.getNewsControlPanelElementsButtonSaveEditingNews());
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()));
    }

    //  TC - 59 - Фильтрация новостей по критерию "Активна", во вкладке "Панель управления" новостей мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void filterNewsByCriterionActive() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        News.clickButtonNews(News.getNewsElementsButtonNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonControlPanel(NewsControlPanel.getNewsControlPanelElementsButtonControlPanel());
        NewsControlPanel.clickFilterNewsControlPanel(NewsControlPanel.getNewsControlPanelElementsFilterNewsControlPanel());
        NewsControlPanel.clickRemoveCheckBoxActive(NewsControlPanel.getNewsControlPanelElementsRemoveCheckBoxActive());
        NewsControlPanel.clickButtonFilterNewsControlPanel(NewsControlPanel.getNewsControlPanelElementsButtonFilterNewsControlPanel());
        SystemClock.sleep(2000);
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()));
    }

    //  TC - 60 - Фильтрация новостей по критерию "Не активна", во вкладке "Панель управления" новостей мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void filterNewsByCriterionNotActive() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        News.clickButtonNews(News.getNewsElementsButtonNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonControlPanel(NewsControlPanel.getNewsControlPanelElementsButtonControlPanel());
        NewsControlPanel.clickFilterNewsControlPanel(NewsControlPanel.getNewsControlPanelElementsFilterNewsControlPanel());
        NewsControlPanel.clickRemoveCheckBoxNotActive(NewsControlPanel.getNewsControlPanelElementsRemoveCheckBoxNotActive());
        NewsControlPanel.clickButtonFilterNewsControlPanel(NewsControlPanel.getNewsControlPanelElementsButtonFilterNewsControlPanel());
        SystemClock.sleep(2000);
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()));
    }

    //  TC - 61 - Создание новости во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void creationNewsInControlPanel() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        News.clickButtonNews(News.getNewsElementsButtonNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonControlPanel(NewsControlPanel.getNewsControlPanelElementsButtonControlPanel());
        NewsControlPanel.clickAddNews(NewsControlPanel.getNewsControlPanelElementsAddNews());
        NewsControlPanel.clickButtonCategoryCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonCategoryCreatingNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonTitleCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonTitleCreatingNews());
        NewsControlPanel.clickButtonDateCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonDateCreatingNews());
        NewsControlPanel.clickButtonOkDateCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonOkDateCreatingNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonTimeCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonTimeCreatingNews());
        NewsControlPanel.clickButtonOkTimeCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonOkTimeCreatingNews());
        NewsControlPanel.clickDescriptionCreatingNews(NewsControlPanel.getNewsControlPanelElementsDescriptionCreatingNews());
        NewsControlPanel.clickButtonSaveCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonSaveCreatingNews());
        SystemClock.sleep(2000);
        onView(allOf(withIndex(withId(R.id.news_item_material_card_view), 0))).check(matches(isDisplayed()));
    }

    //  TC - 62 - Поле "Категория" пустое, при создании новости, во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    public void fieldCategoryEmptyCreationNewsInControlPanel() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        News.clickButtonNews(News.getNewsElementsButtonNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonControlPanel(NewsControlPanel.getNewsControlPanelElementsButtonControlPanel());
        NewsControlPanel.clickAddNews(NewsControlPanel.getNewsControlPanelElementsAddNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonTitleCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonTitleCreatingNews());
        NewsControlPanel.clickButtonDateCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonDateCreatingNews());
        NewsControlPanel.clickButtonOkDateCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonOkDateCreatingNews());
        NewsControlPanel.clickButtonTimeCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonTimeCreatingNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonOkTimeCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonOkTimeCreatingNews());
        NewsControlPanel.clickDescriptionCreatingNews(NewsControlPanel.getNewsControlPanelElementsDescriptionCreatingNews());
        NewsControlPanel.clickButtonSaveCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonSaveCreatingNews());
        SystemClock.sleep(2000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        pressBack();
    }

    //  TC - 63 - Поле "Заголовок" пустое, при создании новости, во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    public void fieldTitleEmptyCreationNewsInControlPanel() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        News.clickButtonNews(News.getNewsElementsButtonNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonControlPanel(NewsControlPanel.getNewsControlPanelElementsButtonControlPanel());
        NewsControlPanel.clickAddNews(NewsControlPanel.getNewsControlPanelElementsAddNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonCategoryCreatingNew(NewsControlPanel.getNewsControlPanelElementsButtonCategoryCreatingNews());
        NewsControlPanel.clickButtonDateCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonDateCreatingNews());
        NewsControlPanel.clickButtonOkDateCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonOkDateCreatingNews());
        NewsControlPanel.clickButtonTimeCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonTimeCreatingNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonOkTimeCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonOkTimeCreatingNews());
        NewsControlPanel.clickDescriptionCreatingNews(NewsControlPanel.getNewsControlPanelElementsDescriptionCreatingNews());
        NewsControlPanel.clickButtonSaveCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonSaveCreatingNews());
        SystemClock.sleep(2000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        pressBack();
    }

    //  TC - 64 - Поле "Дата публикации" пустое, при создании новости, во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    public void fieldDateEmptyCreationNewsInControlPanel() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        News.clickButtonNews(News.getNewsElementsButtonNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonControlPanel(NewsControlPanel.getNewsControlPanelElementsButtonControlPanel());
        NewsControlPanel.clickAddNews(NewsControlPanel.getNewsControlPanelElementsAddNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonCategoryCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonCategoryCreatingNews());
        NewsControlPanel.clickButtonTitleCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonTitleCreatingNews());
        NewsControlPanel.clickButtonTimeCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonTimeCreatingNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonOkTimeCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonOkTimeCreatingNews());
        NewsControlPanel.clickDescriptionCreatingNews(NewsControlPanel.getNewsControlPanelElementsDescriptionCreatingNews());
        NewsControlPanel.clickButtonSaveCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonSaveCreatingNews());
        SystemClock.sleep(2000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        pressBack();
    }

    //  TC - 65 - Поле "Время" пустое, при создании новости, во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    public void fieldTimeEmptyCreationNewsInControlPanel() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        News.clickButtonNews(News.getNewsElementsButtonNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonControlPanel(NewsControlPanel.getNewsControlPanelElementsButtonControlPanel());
        NewsControlPanel.clickAddNews(NewsControlPanel.getNewsControlPanelElementsAddNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonCategoryCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonCategoryCreatingNews());
        NewsControlPanel.clickButtonTitleCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonTitleCreatingNews());
        NewsControlPanel.clickButtonDateCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonDateCreatingNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonOkDateCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonOkDateCreatingNews());
        NewsControlPanel.clickDescriptionCreatingNews(NewsControlPanel.getNewsControlPanelElementsDescriptionCreatingNews());
        NewsControlPanel.clickButtonSaveCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonSaveCreatingNews());
        SystemClock.sleep(2000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        pressBack();
    }

    //  TC - 66 - Поле "Описание" пустое, при создании новости, во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    public void fieldDescriptionEmptyCreationNewsInControlPanel() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        News.clickButtonNews(News.getNewsElementsButtonNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonControlPanel(NewsControlPanel.getNewsControlPanelElementsButtonControlPanel());
        NewsControlPanel.clickAddNews(NewsControlPanel.getNewsControlPanelElementsAddNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonCategoryCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonCategoryCreatingNews());
        NewsControlPanel.clickButtonTitleCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonTitleCreatingNews());
        NewsControlPanel.clickButtonDateCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonDateCreatingNews());
        NewsControlPanel.clickButtonOkDateCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonOkDateCreatingNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonTimeCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonTimeCreatingNews());
        NewsControlPanel.clickButtonOkTimeCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonOkTimeCreatingNews());
        NewsControlPanel.clickButtonSaveCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonSaveCreatingNews());
        SystemClock.sleep(2000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        pressBack();
    }

    //  TC - 67 - Ввод в поле "Категория" собственного названия категории, при создании новости, во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    public void customCategoryName() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        News.clickButtonNews(News.getNewsElementsButtonNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonControlPanel(NewsControlPanel.getNewsControlPanelElementsButtonControlPanel());
        NewsControlPanel.clickAddNews(NewsControlPanel.getNewsControlPanelElementsAddNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonCategoryCreatingNewsEmpty(NewsControlPanel.getNewsControlPanelElementsButtonCategoryCreatingNews());
        NewsControlPanel.clickButtonTitleCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonTitleCreatingNews());
        NewsControlPanel.clickButtonDateCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonDateCreatingNews());
        NewsControlPanel.clickButtonOkDateCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonOkDateCreatingNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonTimeCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonTimeCreatingNews());
        NewsControlPanel.clickButtonOkTimeCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonOkTimeCreatingNews());
        NewsControlPanel.clickDescriptionCreatingNews(NewsControlPanel.getNewsControlPanelElementsDescriptionCreatingNews());
        NewsControlPanel.clickButtonSaveCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonSaveCreatingNews());
        SystemClock.sleep(2000);
        onView(allOf(withContentDescription("Saving failed. Try again later"), isDisplayed()));
        pressBack();

    }
    //  TC - 68 - Поле "Категория" состоит из цифр, при создании новости, во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    public void fieldCategoryConsistsOfNumbers() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        News.clickButtonNews(News.getNewsElementsButtonNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonControlPanel(NewsControlPanel.getNewsControlPanelElementsButtonControlPanel());
        NewsControlPanel.clickAddNews(NewsControlPanel.getNewsControlPanelElementsAddNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonCategoryCreatingNewsNumbers(NewsControlPanel.getNewsControlPanelElementsButtonCategoryCreatingNews());
        NewsControlPanel.clickButtonTitleCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonTitleCreatingNews());
        NewsControlPanel.clickButtonDateCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonDateCreatingNews());
        NewsControlPanel.clickButtonOkDateCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonOkDateCreatingNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonTimeCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonTimeCreatingNews());
        NewsControlPanel.clickButtonOkTimeCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonOkTimeCreatingNews());
        NewsControlPanel.clickDescriptionCreatingNews(NewsControlPanel.getNewsControlPanelElementsDescriptionCreatingNews());
        NewsControlPanel.clickButtonSaveCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonSaveCreatingNews());
        SystemClock.sleep(2000);
        onView(allOf(withContentDescription("Saving failed. Try again later"), isDisplayed()));
        pressBack();

    }
    //  TC - 69 - Поле "Категория" состоит из спецсимволов, при создании новости, во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    public void fieldCategoryConsistsOfSpecialCharacters() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        News.clickButtonNews(News.getNewsElementsButtonNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonControlPanel(NewsControlPanel.getNewsControlPanelElementsButtonControlPanel());
        NewsControlPanel.clickAddNews(NewsControlPanel.getNewsControlPanelElementsAddNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonCategoryCreatingCharacters(NewsControlPanel.getNewsControlPanelElementsButtonCategoryCreatingNews());
        NewsControlPanel.clickButtonTitleCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonTitleCreatingNews());
        NewsControlPanel.clickButtonDateCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonDateCreatingNews());
        NewsControlPanel.clickButtonOkDateCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonOkDateCreatingNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonTimeCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonTimeCreatingNews());
        NewsControlPanel.clickButtonOkTimeCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonOkTimeCreatingNews());
        NewsControlPanel.clickDescriptionCreatingNews(NewsControlPanel.getNewsControlPanelElementsDescriptionCreatingNews());
        NewsControlPanel.clickButtonSaveCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonSaveCreatingNews());
        SystemClock.sleep(2000);
        onView(allOf(withContentDescription("Saving failed. Try again later"), isDisplayed()));
        pressBack();

    }

    //  TC - 70 - Поле "Дата публикации" состоит из даты будущего года, при создании новости, во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void fieldDateConsistsOfNextYearCreatingNews() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        News.clickButtonNews(News.getNewsElementsButtonNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonControlPanel(NewsControlPanel.getNewsControlPanelElementsButtonControlPanel());
        NewsControlPanel.clickAddNews(NewsControlPanel.getNewsControlPanelElementsAddNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonCategoryCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonCategoryCreatingNews());
        NewsControlPanel.clickButtonTitleCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonTitleCreatingNews());
        NewsControlPanel.clickButtonDateCreatingNextDate(NewsControlPanel.getNewsControlPanelElementsButtonDateCreatingNews());
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonTimeCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonTimeCreatingNews());
        NewsControlPanel.clickButtonOkTimeCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonOkTimeCreatingNews());
        NewsControlPanel.clickDescriptionCreatingNews(NewsControlPanel.getNewsControlPanelElementsDescriptionCreatingNews());
        NewsControlPanel.clickButtonSaveCreatingNews(NewsControlPanel.getNewsControlPanelElementsButtonSaveCreatingNews());
        SystemClock.sleep(2000);
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()));
    }
}