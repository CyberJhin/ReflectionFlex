package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementActions {
    private WebDriver driver;

    public WebElementActions(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для поиска элемента по селектору CSS
    public WebElement findElementByCssSelector(String cssSelector) {
        return driver.findElement(By.cssSelector(cssSelector));
    }
    public WebElement findElementByText(String text) {
        return driver.findElement(By.xpath("//*[contains(text(), '" + text + "')]"));
    }

    // Метод для поиска элемента по его id
    public WebElement findElementById(String id) {
        return driver.findElement(By.id(id));
    }

    // Метод для сравнения содержимого элемента с ожидаемым текстом
    public void compareElementText(WebElement element, String expectedText) throws TextComparisonException {
        String actualText = element.getText();
        if (!actualText.equals(expectedText)) {
            throw new TextComparisonException("Содержимое элемента не совпадает с ожидаемым текстом");
        }
        System.out.println("Тест прошел успешно");
    }

    // Метод для нажатия на элемент
    public void clickElement(WebElement element) {
        element.click();
    }

    // Метод для ввода текста в элемент
    public void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }
}

