package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ClassToTest {
    @MyTest
    public void testElementTextComparison() throws TextComparisonException {
        // Установка пути к драйверу Chrome
        // System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        // Настройка опций для браузера Chrome
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Отправка запроса к веб-странице
        driver.get("https://www.example.com");

        // Создание экземпляра класса WebElementActions
        WebElementActions actions = new WebElementActions(driver);

        // Нахождение элемента на странице по его id
        WebElement headingElement = actions.findElementByText("Example Domain");

        // Сравнение содержимого найденного элемента с ожидаемым текстом
        actions.compareElementText(headingElement, "Example Domain");
        // Закрытие сеанса WebDriver
        driver.quit();
    }

    @MyTest
    public void testMethod2() {
        System.out.println("Test method 2");
    }

    public void nonTestMethod() {
        System.out.println("Non-test method");
    }
}

