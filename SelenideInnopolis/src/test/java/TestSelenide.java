import bookStore.pages.RegistrationFormPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

@Epic("Book store")
@Feature("Registration Form")
public class TestSelenide {
    private RegistrationFormPage registrationFormPage;

    @BeforeEach
    void setUp() {
        SelenideLogger.addListener("AllureListener", new AllureSelenide().screenshots(true).savePageSource(true));

        Configuration.baseUrl = "https://demoqa.com/"; // !!! Не забываем слешик !!!
        Configuration.timeout=5000; // Тайм-аут
        Configuration.headless= false; // Тип запуска
        Configuration.browser="chrome"; // Выбор браузера
        Configuration.startMaximized=true; // Положение окна
    }

    @Test
    void name(){
        open("automation-practice-form");
    }

    @Test
    public void name2() {
        registrationFormPage = open("automation-practice-form", RegistrationFormPage.class);
        registrationFormPage.inputFirstName("Igorrrr");
        registrationFormPage.inputLastName("Ivanov");
        registrationFormPage.inputEmail("ivanov5555@test.tt");
        registrationFormPage.inputPhone("9009998811");
        registrationFormPage.selectGender(0);
        registrationFormPage.selectHobby(1);
        registrationFormPage.openDateOfBirthMenu();
        registrationFormPage.selectYear("1980");
        registrationFormPage.selectMonth("May");
        registrationFormPage.selectDay(3);
        registrationFormPage.selectState(0);
        registrationFormPage.selectCity(0);
        registrationFormPage.submitBtnClick();
    }

    @Test
    public void clickTests() {
        open("buttons");
        $(By.id("doubleClickBtn")).doubleClick();
        $(By.id("rightClickBtn")).contextClick();
        $(By.id("doubleClickMessage")).shouldHave(Condition.disabled);
        Assertions.assertTrue($(By.id("rightClickMessage")).isDisplayed());
    }

    // Функция взять и тащить
    @Test
    public void drugAndDropTests() {
        open("https://demoqa.com/droppable");
        SelenideElement drugElement = $(By.id("draggable"));
        SelenideElement dropElement = $(By.id("droppable"));
        actions().dragAndDrop(drugElement, dropElement).perform();
        Assertions.assertEquals("rgba(70, 130, 180, 1)", dropElement.getCssValue("background-color"));
    }

    // Берешь и тащишь
    @Test
    public void clickAndHoldTests() throws InterruptedException {
        open("https://demoqa.com/sortable");
        List<SelenideElement> elementsBeforeMoving = $$(By.cssSelector(".vertical-list-container > div"));
        actions().clickAndHold(elementsBeforeMoving.get(0)).moveToElement(elementsBeforeMoving.get(1)).click().perform();
        List<SelenideElement> elementsAfterMoving = $$(By.cssSelector(".vertical-list-container > div"));
        System.out.println(elementsBeforeMoving.get(0).getText());
        Assertions.assertEquals("Two", elementsAfterMoving.get(0).getText());
    }

    @Test
    public void alertTests() throws InterruptedException {
        open("https://demoqa.com/alerts");
        SelenideElement alertBtn2 = $(By.id("confirmButton"));
        alertBtn2.click();
        Alert alert2 = Selenide.switchTo().alert();
        alert2.dismiss();
        Thread.sleep(5000);
    }

    // Постоянноое время
    @Test
    public void waitUntilVisibleTest() {
        open("https://demoqa.com/dynamic-properties");
        SelenideElement button = $(By.id("visibleAfter")).shouldHave(Condition.visible, Duration.ofSeconds(5));
        button.click();
    }

    // Разрешение дальнейших действий
    @Test
    public void waitUntilDisableTest() {
        open("https://demoqa.com/dynamic-properties");
        SelenideElement button = $(By.id("enableAfter")).shouldHave(Condition.visible, Duration.ofSeconds(5));

        button.click();
    }

    // Изменения цвета кнопки
    @Test
    public void waitUntilColorChangedTest() {
        open("https://demoqa.com/dynamic-properties");
        SelenideElement button = $(By.id("colorChange")).shouldHave(Condition.cssValue("color", "rgba(220, 53, 69, 1)"), Duration.ofSeconds(5));

        button.click();
    }
}
