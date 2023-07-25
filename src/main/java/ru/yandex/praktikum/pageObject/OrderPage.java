package ru.yandex.praktikum.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private final WebDriver webDriver;
    //локатор поля ввода "Имя" на странице заказа
    private By nameField = By.xpath("//input[@placeholder='* Имя']");

    //локатор поля ввода "Фамилия" на странице заказа
    private By lastNameField = By.xpath("//input[@placeholder='* Фамилия']");

    //локатор поля "Адрес: куда привезти заказ" на странице заказа
    private By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");

    //локатор поля ввода "Станция метро" на странице заказа
    private By metroStationField = By.className("select-search__input");

    // локатор выпадающего списка метро на странице заказа
    private By metroStationFieldFull = By.xpath("//*[@class='select-search__select']");

    //локатор поля ввода "Телефон: на него позвонит курьер" на странице заказа
    private By numberPhoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    //локатор кнопки "Далее" на странице заказа
    private By buttonNext = By.xpath("//button[text()='Далее']");

    // локатор поля ввода "Когда привезти самокат" на странице заказа
    private By orderTime = By.xpath("//input[@placeholder='* Когда привезти самокат']");

    //локатор для выбора даты в выпадающем календаре на странице заказа
    private By orderTimeFull = By.xpath("//div[@class='react-datepicker__day react-datepicker__day--016 react-datepicker__day--selected']");

    // локатор для поля "Срок аренды" на странице заказа
    private By rentalPeriod = By.xpath("//div[@class='Dropdown-placeholder']");

    //локатор выпадающего списка в поле "Срок аренды" (двое суток) на странице заказа
    private By rentalTwoDays = By.xpath("//div[@class='Dropdown-option'] [2]");

    //локатор выпадающего списка в поле "Срок аренды" (четверо суток) на странице заказа
    private By rentalFourDays = By.xpath("//div[@class='Dropdown-option'] [4]");

    // локатор чекбокса "Серая безысходность" на странице заказа
    private By checkBoxGreyHopelessnessColor = By.xpath("//input[@id='grey']");

    // локатор чекбокса "Черный жемчуг" на странице заказа
    private By checkBoxBlackPearlColor = By.xpath("//input[@id='black']");

    // локатор кнопки "Заказать" на странице заказа
    private By buttonOnOrderPage = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // локатор кнопки "Да" на странице подтверждения заказа
    private By confirmationButton = By.xpath("//button[text()='Да']");

    // локатор подтверждения заказа
    private By orderConfirmation = By.xpath("//div[text()='Заказ оформлен']");

    //локатор поля ввода "Комментарий для курьера" на странице заказа
    private By commentField = By.xpath("//input[@placeholder='Комментарий для курьера']");
    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void enterOrderName(String text) {
        webDriver.findElement(nameField).sendKeys(text);
    }

    public void enterOrderLastName(String text) {
        webDriver.findElement(lastNameField).sendKeys(text);
    }

    public void enterOrderAddress(String text) {
        webDriver.findElement(addressField).sendKeys(text);
    }

    public void enterMetroStation(String text) {
        webDriver.findElement(metroStationField).sendKeys(text);
    }

    public void clickMetroStationFull() {
        webDriver.findElement(metroStationFieldFull).click();
    }

    public void enterNumberPhone(String text) {
        webDriver.findElement(numberPhoneField).sendKeys(text);
    }

    public void clickOrderButtonNext() {
        webDriver.findElement(buttonNext).click();
    }

    public void enterOrderTime(String text) {
        webDriver.findElement(orderTime).sendKeys(text, Keys.ENTER);
    }

    public void clickOrderRentalPeriod() {
        webDriver.findElement(rentalPeriod).click();
    }

    public void enterOrderRentalTwoDay() {
        webDriver.findElement(rentalTwoDays).click();
    }

    public void enterOrderRentalFourDay() {
        webDriver.findElement(rentalFourDays).click();
    }

    public void clickCheckBoxGreyColorScooter() {
        webDriver.findElement(checkBoxGreyHopelessnessColor).click();
    }

    public void clickCheckBoxBlackColorScooter() {
        webDriver.findElement(checkBoxGreyHopelessnessColor).click();
    }

    public void enterOrderComment(String text) {
        webDriver.findElement(commentField).sendKeys(text);
    }

    public void clickOrderButtonOnOrderPage() {
        webDriver.findElement(buttonOnOrderPage).click();
    }

    public void clickOrderConfirmationButton() {
        webDriver.findElement(confirmationButton).click();
    }

    public boolean checkOrderConfirmationIsDisplayed() {
        return webDriver.findElement(orderConfirmation).isDisplayed();
    }
}
