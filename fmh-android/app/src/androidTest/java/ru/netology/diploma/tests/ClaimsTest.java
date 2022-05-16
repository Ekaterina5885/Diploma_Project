package ru.netology.diploma.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.isFocusable;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.netology.diploma.util.Util.nestedScrollTo;

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
import ru.netology.diploma.elements.Authorization;
import ru.netology.diploma.elements.Claims;

@LargeTest
@RunWith(AndroidJUnit4.class)
//@RunWith(AllureAndroidJUnit4.class)

public class ClaimsTest {

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
}