package ru.netology.diploma.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.isFocusable;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import static ru.netology.diploma.util.Util.nestedScrollTo;
import static ru.netology.diploma.util.Util.withIndex;

import android.os.SystemClock;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewInteraction;
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
import ru.netology.diploma.elements.Main;
import ru.netology.diploma.elements.News;
import ru.netology.diploma.elements.NewsControlPanel;
import ru.netology.diploma.elements.Quotes;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

public class AllTests {

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void Authorization() {
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
    public void Exit() {
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

//  Тест-кейсы для проведения функционального тестирования вкладки "Заявки" мобильного приложения "Мобильный хоспис".

    //  TC - 14 - Фильтрация заявок по критерию "Открыта" во вкладке "Заявки" мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    public void applicationFilteringInProgress() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        Claims.clickButtonClaims(Claims.getClaimsElementsButtonClaims());
        SystemClock.sleep(1000);
        Claims.clickButtonFilter(Claims.getClaimsElementsButtonFilter());
        Claims.clickRemoveCheckBoxOpen(Claims.getClaimsElementsRemoveCheckBoxOpen());
        Claims.clickButtonOk(Claims.getClaimsElementsButtonOk());
        SystemClock.sleep(1000);
        onView(withId(R.id.claim_list_recycler_view)).check(matches(isEnabled()));
    }

    //  TC - 15 - Фильтрация заявок по критерию "В работе" во вкладке "Заявки" мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    public void applicationFilteringOpen() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        Claims.clickButtonClaims(Claims.getClaimsElementsButtonClaims());
        SystemClock.sleep(1000);
        Claims.clickButtonFilter(Claims.getClaimsElementsButtonFilter());
        Claims.clickRemoveCheckBoxInProgress(Claims.getClaimsElementsRemoveCheckBoxInProgress());
        Claims.clickButtonOk(Claims.getClaimsElementsButtonOk());
        SystemClock.sleep(1000);
        onView(withId(R.id.claim_list_recycler_view)).check(matches(isEnabled()));
    }

    //  TC - 16 - Фильтрация заявок по критерию "Выполнена" во вкладке "Заявки" мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    public void applicationFilteringExecuted() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        Claims.clickButtonClaims(Claims.getClaimsElementsButtonClaims());
        SystemClock.sleep(1000);
        Claims.clickButtonFilter(Claims.getClaimsElementsButtonFilter());
        Claims.clickRemoveCheckBoxOpen(Claims.getClaimsElementsRemoveCheckBoxOpen());
        Claims.clickRemoveCheckBoxInProgress(Claims.getClaimsElementsRemoveCheckBoxInProgress());
        Claims.clickCheckBoxExecuted(Claims.getClaimsElementsCheckBoxExecuted());
        Claims.clickButtonOk(Claims.getClaimsElementsButtonOk());
        SystemClock.sleep(1000);
        onView(withId(R.id.claim_list_recycler_view)).check(matches(isEnabled()));
    }

    //  TC - 17 - Фильтрация заявок по критерию "Отмененные" во вкладке "Заявки" мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    public void applicationFilteringCancelled() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        Claims.clickButtonClaims(Claims.getClaimsElementsButtonClaims());
        SystemClock.sleep(1000);
        Claims.clickButtonFilter(Claims.getClaimsElementsButtonFilter());
        Claims.clickRemoveCheckBoxOpen(Claims.getClaimsElementsRemoveCheckBoxOpen());
        Claims.clickRemoveCheckBoxInProgress(Claims.getClaimsElementsRemoveCheckBoxInProgress());
        SystemClock.sleep(2000);
        Claims.clickCheckBoxCancelled(Claims.getClaimsElementsCheckBoxCancelled());
        Claims.clickButtonOk(Claims.getClaimsElementsButtonOk());
        SystemClock.sleep(1000);
        onView(withId(R.id.claim_list_recycler_view)).check(matches(isEnabled()));
    }

    //  TC - 18 - Создание заявки во вкладке "Заявки" мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    public void addNewClaim() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        Claims.clickButtonClaims(Claims.getClaimsElementsButtonClaims());
        SystemClock.sleep(1000);
        Claims.clickButtonAddClaim(Claims.getClaimsElementsButtonAddClaim());
        Claims.clickTitleField(Claims.getClaimsElementsTitleField());
        Claims.clickCheckBoxExecutorField(Claims.getClaimsElementsExecutorField());
        Claims.clickDateField(Claims.getClaimsElementsDateField());
        Claims.clickButtonOkDate(Claims.getClaimsElementsButtonOkDate());
        SystemClock.sleep(1000);
        Claims.clickTimeField(Claims.getClaimsElementsTimeField());
        Claims.clickButtonOkTime(Claims.getClaimsElementsButtonOkTime());
        Claims.clickDescriptionField(Claims.getClaimsElementsDescriptionField());
        Claims.clickButtonSave(Claims.getClaimsElementsButtonSave());
        SystemClock.sleep(1000);
        onView(withId(R.id.claim_list_recycler_view)).check(matches(isDisplayed()));
    }

    //  TC - 19 - Поле "Тема" пустое, при создании заявки, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    public void titleFieldIsEmpty() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        Claims.clickButtonClaims(Claims.getClaimsElementsButtonClaims());
        SystemClock.sleep(2000);
        Claims.clickButtonAddClaim(Claims.getClaimsElementsButtonAddClaim());
        Claims.clickCheckBoxExecutorField(Claims.getClaimsElementsExecutorField());
        Claims.clickDateField(Claims.getClaimsElementsDateField());
        Claims.clickButtonOkDate(Claims.getClaimsElementsButtonOkDate());
        SystemClock.sleep(1000);
        Claims.clickTimeField(Claims.getClaimsElementsTimeField());
        Claims.clickButtonOkTime(Claims.getClaimsElementsButtonOkTime());
        Claims.clickDescriptionField(Claims.getClaimsElementsDescriptionField());
        Claims.clickButtonSave(Claims.getClaimsElementsButtonSave());
        SystemClock.sleep(2000);
        onView(allOf(withId(R.id.message), isFocusable()));
        Claims.clickButtonOkError(Claims.getClaimsElementsButtonOkError());
        SystemClock.sleep(2000);
        onView(allOf(withId(R.id.text_input_end_icon), isFocusable()));
        Claims.clickButtonCancelClaim(Claims.getClaimsElementsButtonCancelClaim());
        Claims.clickButtonOkNotification(Claims.getClaimsElementsButtonOkNotification());
    }

    //  TC - 20 - Поле "Тема" состоит из одного символа, при создании заявки, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    public void titleFieldOneCharacter() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        Claims.clickButtonClaims(Claims.getClaimsElementsButtonClaims());
        SystemClock.sleep(2000);
        Claims.clickButtonAddClaim(Claims.getClaimsElementsButtonAddClaim());
        Claims.clickTitleFieldOneCharacter(Claims.getClaimsElementsTitleField());
        Claims.clickCheckBoxExecutorField(Claims.getClaimsElementsExecutorField());
        Claims.clickDateField(Claims.getClaimsElementsDateField());
        Claims.clickButtonOkDate(Claims.getClaimsElementsButtonOkDate());
        SystemClock.sleep(1000);
        Claims.clickTimeField(Claims.getClaimsElementsTimeField());
        Claims.clickButtonOkTime(Claims.getClaimsElementsButtonOkTime());
        Claims.clickDescriptionField(Claims.getClaimsElementsDescriptionField());
        Claims.clickButtonSave(Claims.getClaimsElementsButtonSave());
        SystemClock.sleep(2000);
        onView(withId(R.id.all_claims_cards_block_constraint_layout)).check(matches(isDisplayed()));
    }

    //  TC - 21 - Поле "Тема" состоит из максимально-допустимого количество символов, при создании заявки, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    public void titleFieldMaximumCharacters() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        Claims.clickButtonClaims(Claims.getClaimsElementsButtonClaims());
        SystemClock.sleep(2000);
        Claims.clickButtonAddClaim(Claims.getClaimsElementsButtonAddClaim());
        Claims.clickTitleFieldMaximumCharacters(Claims.getClaimsElementsTitleField());
        Claims.clickCheckBoxExecutorField(Claims.getClaimsElementsExecutorField());
        Claims.clickDateField(Claims.getClaimsElementsDateField());
        Claims.clickButtonOkDate(Claims.getClaimsElementsButtonOkDate());
        SystemClock.sleep(1000);
        Claims.clickTimeField(Claims.getClaimsElementsTimeField());
        Claims.clickButtonOkTime(Claims.getClaimsElementsButtonOkTime());
        Claims.clickDescriptionField(Claims.getClaimsElementsDescriptionField());
        Claims.clickButtonSave(Claims.getClaimsElementsButtonSave());
        SystemClock.sleep(2000);
        onView(withId(R.id.all_claims_cards_block_constraint_layout)).check(matches(isDisplayed()));
    }

    //  TC - 22 - Поле "Исполнитель" пустое, при создании заявки, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    public void executorFieldIsEmpty() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        Claims.clickButtonClaims(Claims.getClaimsElementsButtonClaims());
        SystemClock.sleep(2000);
        Claims.clickButtonAddClaim(Claims.getClaimsElementsButtonAddClaim());
        Claims.clickTitleField(Claims.getClaimsElementsTitleField());
        Claims.clickDateField(Claims.getClaimsElementsDateField());
        Claims.clickButtonOkDate(Claims.getClaimsElementsButtonOkDate());
        SystemClock.sleep(1000);
        Claims.clickTimeField(Claims.getClaimsElementsTimeField());
        Claims.clickButtonOkTime(Claims.getClaimsElementsButtonOkTime());
        Claims.clickDescriptionField(Claims.getClaimsElementsDescriptionField());
        SystemClock.sleep(1000);
        Claims.clickButtonSave(Claims.getClaimsElementsButtonSave());
        SystemClock.sleep(2000);
        onView(withId(R.id.all_claims_cards_block_constraint_layout)).check(matches(isDisplayed()));
    }

    //  TC - 23 - Ввод в поле "Исполнитель" данных, при создании заявки, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    public void executorFieldOtherData() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        Claims.clickButtonClaims(Claims.getClaimsElementsButtonClaims());
        SystemClock.sleep(2000);
        Claims.clickButtonAddClaim(Claims.getClaimsElementsButtonAddClaim());
        Claims.clickTitleField(Claims.getClaimsElementsTitleField());
        Claims.clickExecutorFieldOtherData(Claims.getClaimsElementsExecutorField());
        Claims.clickDateField(Claims.getClaimsElementsDateField());
        Claims.clickButtonOkDate(Claims.getClaimsElementsButtonOkDate());
        SystemClock.sleep(1000);
        Claims.clickTimeField(Claims.getClaimsElementsTimeField());
        Claims.clickButtonOkTime(Claims.getClaimsElementsButtonOkTime());
        Claims.clickDescriptionField(Claims.getClaimsElementsDescriptionField());
        Claims.clickButtonSave(Claims.getClaimsElementsButtonSave());
        SystemClock.sleep(2000);
        onView(withId(R.id.all_claims_cards_block_constraint_layout)).check(matches(isDisplayed()));
    }

    //  TC - 24 - Поле "Исполнитель" состоит из букв и цифр, при создании заявки, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    public void ExecutorFieldConsistsLettersAndNumbers() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        Claims.clickButtonClaims(Claims.getClaimsElementsButtonClaims());
        SystemClock.sleep(2000);
        Claims.clickButtonAddClaim(Claims.getClaimsElementsButtonAddClaim());
        Claims.clickTitleField(Claims.getClaimsElementsTitleField());
        Claims.clickExecutorFieldConsistsLettersAndNumbers(Claims.getClaimsElementsExecutorField());
        Claims.clickDateField(Claims.getClaimsElementsDateField());
        Claims.clickButtonOkDate(Claims.getClaimsElementsButtonOkDate());
        SystemClock.sleep(1000);
        Claims.clickTimeField(Claims.getClaimsElementsTimeField());
        Claims.clickButtonOkTime(Claims.getClaimsElementsButtonOkTime());
        Claims.clickDescriptionField(Claims.getClaimsElementsDescriptionField());
        Claims.clickButtonSave(Claims.getClaimsElementsButtonSave());
        SystemClock.sleep(2000);
        onView(withId(R.id.all_claims_cards_block_constraint_layout)).check(matches(isDisplayed()));
    }

    //  TC - 25 - Поле "Исполнитель" состоит из спецсимволов, при создании заявки, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    public void ExecutorFieldSpecialCharacters() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        Claims.clickButtonClaims(Claims.getClaimsElementsButtonClaims());
        SystemClock.sleep(2000);
        Claims.clickButtonAddClaim(Claims.getClaimsElementsButtonAddClaim());
        Claims.clickTitleField(Claims.getClaimsElementsTitleField());
        Claims.clickExecutorFieldSpecialCharacters(Claims.getClaimsElementsExecutorField());
        Claims.clickDateField(Claims.getClaimsElementsDateField());
        Claims.clickButtonOkDate(Claims.getClaimsElementsButtonOkDate());
        SystemClock.sleep(1000);
        Claims.clickTimeField(Claims.getClaimsElementsTimeField());
        Claims.clickButtonOkTime(Claims.getClaimsElementsButtonOkTime());
        Claims.clickDescriptionField(Claims.getClaimsElementsDescriptionField());
        Claims.clickButtonSave(Claims.getClaimsElementsButtonSave());
        SystemClock.sleep(2000);
        onView(withId(R.id.all_claims_cards_block_constraint_layout)).check(matches(isDisplayed()));
    }

    //  TC - 26 - Поле "Дата" состоит из даты будущего года, при создании заявки, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void DescriptionFieldIsEmpty() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        Claims.clickButtonClaims(Claims.getClaimsElementsButtonClaims());
        SystemClock.sleep(2000);
        Claims.clickButtonAddClaim(Claims.getClaimsElementsButtonAddClaim());
        Claims.clickTitleField(Claims.getClaimsElementsTitleField());
        Claims.clickCheckBoxExecutorField(Claims.getClaimsElementsExecutorField());
        Claims.clickDateFieldNextYear(Claims.getClaimsElementsDateField());
        SystemClock.sleep(2000);
        Claims.clickTimeField(Claims.getClaimsElementsTimeField());
        Claims.clickButtonOkTime(Claims.getClaimsElementsButtonOkTime());
        Claims.clickDescriptionField(Claims.getClaimsElementsDescriptionField());
        Claims.clickButtonSave(Claims.getClaimsElementsButtonSave());
        SystemClock.sleep(2000);
        onView(withId(R.id.all_claims_cards_block_constraint_layout)).check(matches(isDisplayed()));
    }

    //  TC - 29 - Поле "Описание" пустое, при создании заявки, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    public void DateFieldNextYear() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        Claims.clickButtonClaims(Claims.getClaimsElementsButtonClaims());
        SystemClock.sleep(2000);
        Claims.clickButtonAddClaim(Claims.getClaimsElementsButtonAddClaim());
        Claims.clickTitleField(Claims.getClaimsElementsTitleField());
        Claims.clickCheckBoxExecutorField(Claims.getClaimsElementsExecutorField());
        Claims.clickDateField(Claims.getClaimsElementsDateField());
        Claims.clickButtonOkDate(Claims.getClaimsElementsButtonOkDate());
        SystemClock.sleep(2000);
        Claims.clickTimeField(Claims.getClaimsElementsTimeField());
        Claims.clickButtonOkTime(Claims.getClaimsElementsButtonOkTime());
        Claims.clickButtonSave(Claims.getClaimsElementsButtonSave());
        SystemClock.sleep(2000);
        onView(allOf(withId(R.id.message), isFocusable()));
        Claims.clickButtonOkError(Claims.getClaimsElementsButtonOkError());
        SystemClock.sleep(1000);
        onView(allOf(withId(R.id.text_input_end_icon), isFocusable()));
        Claims.clickButtonCancelClaim(Claims.getClaimsElementsButtonCancelClaim());
        Claims.clickButtonOkNotification(Claims.getClaimsElementsButtonOkNotification());
    }

    //  TC - 30 - Редактирование заявки, находящаяся в статусе "Открыта", во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void EditClaimStatusOpen() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        Claims.clickButtonClaims(Claims.getClaimsElementsButtonClaims());
        SystemClock.sleep(2000);
        Claims.clickButtonFilter(Claims.getClaimsElementsButtonFilter());
        Claims.clickRemoveCheckBoxInProgress(Claims.getClaimsElementsRemoveCheckBoxInProgress());
        Claims.clickButtonOk(Claims.getClaimsElementsButtonOk());
        SystemClock.sleep(2000);
        Claims.clickOpenClaim(Claims.getClaimsElementsOpenClaim());
        SystemClock.sleep(1000);
        onView(withId(android.R.id.content)).perform(swipeUp());
        Claims.clickEditClaim(Claims.getClaimsElementsEditClaim());
        SystemClock.sleep(1000);
        Claims.clickEditClaimStatusOpen(Claims.getClaimsElementsDescriptionField());
        Claims.clickButtonSave(Claims.getClaimsElementsButtonSave());
        SystemClock.sleep(1000);
        ViewInteraction buttonBackClaim = onView(withId(R.id.close_image_button)).perform(nestedScrollTo());
        buttonBackClaim.perform(click());
        SystemClock.sleep(1000);
        onView(withId(R.id.all_claims_cards_block_constraint_layout)).check(matches(isDisplayed()));
    }

    //  TC - 31 - Добавление комментария к заявке, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void AddComment() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        Claims.clickButtonClaims(Claims.getClaimsElementsButtonClaims());
        SystemClock.sleep(2000);
        Claims.clickOpenClaim(Claims.getClaimsElementsOpenClaim());
        SystemClock.sleep(1000);
        onView(withId(android.R.id.content)).perform(swipeUp());
        onView(withId(android.R.id.content)).perform(swipeUp());
        onView(withId(android.R.id.content)).perform(swipeUp());
        SystemClock.sleep(2000);
        Claims.clickButtonAddComment(Claims.getClaimsElementsButtonAddComment());
        SystemClock.sleep(2000);
        Claims.clickCommentField(Claims.getClaimsElementsCommentField());
        Claims.clickButtonSave(Claims.getClaimsElementsButtonSave());
        SystemClock.sleep(2000);
        onView(withId(android.R.id.content)).perform(swipeUp());
        onView(withId(android.R.id.content)).perform(swipeUp());
        onView(withId(android.R.id.content)).perform(swipeUp());
        onView(withId(R.id.comments_material_card_view)).check(matches(isDisplayed()));
    }

    //  TC - 32 - Редактирование комментария к заявке, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void EditComment() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        Claims.clickButtonClaims(Claims.getClaimsElementsButtonClaims());
        SystemClock.sleep(2000);
        Claims.clickOpenClaim(Claims.getClaimsElementsOpenClaim());
        SystemClock.sleep(1000);
        Claims.clickButtonEditComment(Claims.getClaimsElementsButtonEditComment());
        Claims.clickCommentField(Claims.getClaimsElementsCommentField());
        Claims.clickButtonSave(Claims.getClaimsElementsButtonSave());
        SystemClock.sleep(2000);
        onView(withId(R.id.comments_material_card_view)).check(matches(isDisplayed()));
    }

    //  TC - 33 - Смена статуса заявки, находящаяся в статусе "Открыта" на статус "В работе", во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void ChangeStatusOpenForInProgress() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        Claims.clickButtonClaims(Claims.getClaimsElementsButtonClaims());
        SystemClock.sleep(2000);
        Claims.clickButtonFilter(Claims.getClaimsElementsButtonFilter());
        Claims.clickRemoveCheckBoxInProgress(Claims.getClaimsElementsRemoveCheckBoxInProgress());
        Claims.clickButtonOk(Claims.getClaimsElementsButtonOk());
        SystemClock.sleep(2000);
        Claims.clickOpenClaim(Claims.getClaimsElementsOpenClaim());
        Claims.clickButtonSettings(Claims.getClaimsElementsButtonSettings());
        SystemClock.sleep(2000);
        Claims.clickButtonTakeToWork(Claims.getClaimsElementsButtonTakeToWork());
        SystemClock.sleep(2000);
        onView(withId(R.id.status_label_text_view))
                .check(matches(withText("In progress")))
                .check(matches(isDisplayed()));
    }

    //  TC - 34 - Смена статуса заявки, находящаяся в статусе "Открыта" на статус "В работе", во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void ChangeStatusOpenForCanceled() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        Claims.clickButtonClaims(Claims.getClaimsElementsButtonClaims());
        SystemClock.sleep(2000);
        Claims.clickButtonFilter(Claims.getClaimsElementsButtonFilter());
        Claims.clickRemoveCheckBoxInProgress(Claims.getClaimsElementsRemoveCheckBoxInProgress());
        Claims.clickButtonOk(Claims.getClaimsElementsButtonOk());
        SystemClock.sleep(2000);
        onView(withId(android.R.id.content)).perform(swipeDown());
        Claims.clickOpenClaim(Claims.getClaimsElementsOpenClaim());
        SystemClock.sleep(2000);
        onView(withId(android.R.id.content)).perform(swipeUp());
        Claims.clickButtonSettings(Claims.getClaimsElementsButtonSettings());
        SystemClock.sleep(2000);
        Claims.clickButtonCancel(Claims.getClaimsElementsButtonCancel());
        SystemClock.sleep(2000);
        onView(withId(android.R.id.content)).perform(swipeDown());
        onView(withId(R.id.status_label_text_view))
                .check(matches(withText("Canceled")))
                .check(matches(isDisplayed()));
    }

    //  TC - 35 - Смена статуса заявки, с истекшим сроком  исполнения, находящаяся в статусе "Открыта" на статус "В работу", во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void ChangeStatusOpenForInProgressExpired() {
        SystemClock.sleep(5000);
        Claims.clickButtonMainMenu(Claims.getClaimsElementsButtonMainMenu());
        Claims.clickButtonClaims(Claims.getClaimsElementsButtonClaims());
        SystemClock.sleep(2000);
        Claims.clickButtonFilter(Claims.getClaimsElementsButtonFilter());
        Claims.clickRemoveCheckBoxInProgress(Claims.getClaimsElementsRemoveCheckBoxInProgress());
        Claims.clickButtonOk(Claims.getClaimsElementsButtonOk());
        SystemClock.sleep(2000);
        Claims.clickOpenClaim(Claims.getClaimsElementsOpenClaim());
        Claims.clickButtonSettings(Claims.getClaimsElementsButtonSettings());
        SystemClock.sleep(2000);
        Claims.clickButtonTakeToWork(Claims.getClaimsElementsButtonTakeToWork());
        SystemClock.sleep(2000);
        onView(withId(R.id.status_label_text_view))
                .check(matches(withText("In progress")))
                .check(matches(isDisplayed()));
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

//  Тест-кейсы для проведения функционального тестирования вкладки "Тематические цитаты" мобильного приложения "Мобильный хоспис".

    //  TC - 73 - Развернуть/свернуть тематическую цитату, во вкладке "Главное - жить любя", мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void expandThematicQuote() {
        SystemClock.sleep(5000);
        Quotes.clickButtonThematicQuote(Quotes.getQuotesElementsButtonThematicQuote());
        SystemClock.sleep(2000);
        Quotes.clickTitleThematicQuote(Quotes.getQuotesElementsTitleThematicQuote());
        Quotes.clickButtonExpandThematicQuote(Quotes.getQuotesElementsButtonExpandThematicQuote());
        Quotes.clickDescriptionThematicQuote(Quotes.getQuotesElementsDescriptionThematicQuote());
        SystemClock.sleep(1000);
        onView(withId(R.id.our_mission_item_list_recycler_view)).check(matches(isDisplayed()));
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