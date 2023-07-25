package ru.yandex.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.praktikum.pageObject.MainPage;
import ru.yandex.praktikum.pageObject.OrderPage;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)

public class OrderPageTest {
    WebDriver webDriver;
    private final String name;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String numberPhone;
    private final String time;
    private final String comment;
    private final boolean isOrderButton;
    public OrderPageTest(String name, String lastName, String address, String metroStation, String numberPhone, String time, String comment, boolean isOrderButton) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.numberPhone = numberPhone;
        this.time = time;
        this.comment = comment;
        this.isOrderButton = isOrderButton;
    }
    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                {"Сергей", "Епишин", "ул. Ленина, д.9, кв. 65", "Щелковская", "79262734319", "26.07.2023", "позвоните зя 5 минут до приезда", true},
                {"Лена", "Головач", "Королев", "ВДНХ", "79264779988", "14.08.2023", "дверь в подъезд открыта", false},
                {"Владимир", "Жириновский", "ул. Охотный ряд, д. 4", "Охотный ряд", "79222222222", "01.06.21", "", true},
                {"Артемий", "Лебедев", "Москва", "Чистые пруды", "77777777777", "14.08.2023", "постучите в дверь", false},
        };
    }
    @Before
    public void setupAll() {
      WebDriverManager.chromedriver().setup();
      webDriver = new ChromeDriver();
  //  WebDriverManager.firefoxdriver().setup();
  //  webDriver = new FirefoxDriver();
    }

    @Test
    public void checkOrderPositiveScenario() {
        OrderPage orderPage = new OrderPage(webDriver);
        MainPage mainPage = new MainPage(webDriver);
        mainPage.open();
        mainPage.clickButtonCookies();
        mainPage.clickOrderButton(isOrderButton);
        orderPage.enterOrderName(name);
        orderPage.enterOrderLastName(lastName);
        orderPage.enterOrderAddress(address);
        orderPage.enterMetroStation(metroStation);
        orderPage.clickMetroStationFull();
        orderPage.enterNumberPhone(numberPhone);
        orderPage.clickOrderButtonNext();
        orderPage.enterOrderTime(time);
        orderPage.clickOrderRentalPeriod();
        orderPage.enterOrderRentalTwoDay();
        orderPage.clickCheckBoxGreyColorScooter();
        orderPage.enterOrderComment(comment);
        orderPage.clickOrderButtonOnOrderPage();
        orderPage.clickOrderConfirmationButton();
        boolean isDisplayed = orderPage.checkOrderConfirmationIsDisplayed();
        Assert.assertTrue("Confirmation is not displayed", isDisplayed);
    }

    @After
    public void clear() {
        // Закрыть браузер
        webDriver.quit();
    }
}