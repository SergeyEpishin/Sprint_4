package ru.yandex.praktikum.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {
    WebDriver webDriver;
    // локатор кнопки "Заказать" вверху главной страницы
    private By topOrderButton = By.xpath("//button[@class='Button_Button__ra12g']");
    // локатор кнопки "Заказать" в середине главной страницы
    private By middleOrderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //локатор первого вопроса выпадающего списка "Вопросы о важном": "Сколько это стоит и как оплатить?"
    private By dropDownListFirstQuestion = By.id("accordion__heading-0");
    //локатор текста первого пункта выпадающего списка
    private By dropDownListFirstAnswer = By.xpath("//*[@id='accordion__panel-0']/p");
    //локатор второго вопроса выпадающего списка "Вопросы о важном": "Хочу сразу несколько самокатов! Так можно?"
    private By dropDownListSecondQuestion = By.id("accordion__heading-1");
    //локатор текста второго пункта выпадающего списка
    private By dropDownListSecondAnswer = By.xpath("//*[@id='accordion__panel-1']/p");
    //локатор третьего вопроса выпадающего списка "Вопросы о важном": "Как рассчитывается время аренды?"
    private By dropDownListThirdQuestion = By.id("accordion__heading-2");
    //локатор текста третьего пункта выпадающего списка
    private By dropDownListThirdAnswer = By.xpath("//*[@id='accordion__panel-2']/p");
    //локатор четвертого вопроса выпадающего списка "Вопросы о важном": "Можно ли заказать самокат прямо на сегодня?"
    private By dropDownListFourthQuestion = By.id("accordion__heading-3");
    //локатор текста четвертого пункта выпадающего списка
    private By dropDownListFourthAnswer = By.xpath("//*[@id='accordion__panel-3']/p");
    //локатор пятого вопроса выпадающего списка "Вопросы о важном": "Можно ли продлить заказ или вернуть самокат раньше?"
    private By dropDownListFifthQuestion = By.id("accordion__heading-4");
    //локатор текста пятого пункта выпадающего списка
    private By dropDownListFifthAnswer = By.xpath("//*[@id='accordion__panel-4']/p");
    //локатор шестого вопроса выпадающего списка "Вопросы о важном": "Вы привозите зарядку вместе с самокатом?"
    private By dropDownListSixthQuestion = By.id("accordion__heading-5");
    //локатор текста шестого пункта выпадающего списка
    private By dropDownListSixthAnswer = By.xpath("//*[@id='accordion__panel-5']/p");
    //локатор седьмого вопроса выпадающего списка "Вопросы о важном": "Можно ли отменить заказ?"
    private By dropDownListSeventhQuestion = By.id("accordion__heading-6");
    //локатор текста седьмого пункта выпадающего списка
    private By dropDownListSeventhAnswer = By.xpath("//*[@id='accordion__panel-6']/p");
    //локатор восьмого вопроса выпадающего списка "Вопросы о важном": "Я жизу за МКАДом, привезёте?"
    private By dropDownListEighthQuestion = By.id("accordion__heading-7");
    //локатор текста восьмого пункта выпадающего списка
    private By dropDownListEighthAnswer = By.xpath("//*[@id='accordion__panel-7']/p");
    // локатор кнопки принятия кук "да все привыкли"
    private By buttonCookies = By.id("rcc-confirm-button");

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void open() {
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
    }
    public void clickOrderButton(boolean isOrderButton) {
        if (isOrderButton) {
            webDriver.findElement(topOrderButton).click();
        } else {
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", webDriver.findElement(middleOrderButton));
            webDriver.findElement(middleOrderButton).click();
        }
    }
    public void scrollToQuestion(By dropQuestion) {
        WebElement dropDownQuestionElement = webDriver.findElement(dropQuestion);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", dropDownQuestionElement);
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.elementToBeClickable(dropDownQuestionElement));
    }
    public String clickDropDownList(String dropDownQuestion) {
        if ("Сколько это стоит? И как оплатить?".equals(dropDownQuestion)) {
            scrollToQuestion(dropDownListFirstQuestion);
            webDriver.findElement(dropDownListFirstQuestion).click();
            return webDriver.findElement(dropDownListFirstAnswer).getText();
        } else if ("Хочу сразу несколько самокатов! Так можно?".equals(dropDownQuestion)) {
            scrollToQuestion(dropDownListSecondQuestion);
            webDriver.findElement(dropDownListSecondQuestion).click();
            return webDriver.findElement(dropDownListSecondAnswer).getText();
        } else if ("Как рассчитывается время аренды?".equals(dropDownQuestion)) {
            scrollToQuestion(dropDownListThirdQuestion);
            webDriver.findElement(dropDownListThirdQuestion).click();
            return webDriver.findElement(dropDownListThirdAnswer).getText();
        } else if ("Можно ли заказать самокат прямо на сегодня?".equals(dropDownQuestion)) {
            scrollToQuestion(dropDownListFourthQuestion);
            webDriver.findElement(dropDownListFourthQuestion).click();
            return webDriver.findElement(dropDownListFourthAnswer).getText();
        } else if ("Можно ли продлить заказ или вернуть самокат раньше?".equals(dropDownQuestion)) {
            scrollToQuestion(dropDownListFifthQuestion);
            webDriver.findElement(dropDownListFifthQuestion).click();
            return webDriver.findElement(dropDownListFifthAnswer).getText();
        } else if ("Вы привозите зарядку вместе с самокатом?".equals(dropDownQuestion)) {
            scrollToQuestion(dropDownListSixthQuestion);
            webDriver.findElement(dropDownListSixthQuestion).click();
            return webDriver.findElement(dropDownListSixthAnswer).getText();
        } else if ("Можно ли отменить заказ?".equals(dropDownQuestion)) {
            scrollToQuestion(dropDownListSeventhQuestion);
            webDriver.findElement(dropDownListSeventhQuestion).click();
            return webDriver.findElement(dropDownListSeventhAnswer).getText();
        } else if ("Я жизу за МКАДом, привезёте?".equals(dropDownQuestion)) {
            scrollToQuestion(dropDownListEighthQuestion);
            webDriver.findElement(dropDownListEighthQuestion).click();
            return webDriver.findElement(dropDownListEighthAnswer).getText();
        } else {
            throw new IllegalArgumentException("Вопрос не найден: " + dropDownQuestion);
        }
    }

    public void clickButtonCookies() {
        webDriver.findElement(buttonCookies).click();
    }
}
