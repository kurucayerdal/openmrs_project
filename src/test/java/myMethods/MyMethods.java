package myMethods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Driver;

import java.time.Duration;

public class MyMethods {

    public void waitUntilVisibleFunction(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickableFunction(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        waitUntilVisibleFunction(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickFunction(WebElement element) {
        waitUntilVisibleFunction(element);
        waitUntilClickableFunction(element);
        element.click();
    }

    public void sendKeysFunction(WebElement element, String text) {
        waitUntilVisibleFunction(element);
        element.clear();
        element.sendKeys(text);
    }

    public void verifyText(WebElement element, String text) {
        waitUntilVisibleFunction(element);
        Assert.assertEquals(element.getText().trim(), text);
    }

    public void elementIsVisible(WebElement element) {
        Assert.assertTrue(element.isDisplayed());
    }

    public void waitUntilTextToBe(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        waitUntilVisibleFunction(element);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        Assert.assertTrue(element.getText().trim().equalsIgnoreCase(text));
    }


}
