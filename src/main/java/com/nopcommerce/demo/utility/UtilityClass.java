package com.nopcommerce.demo.utility;

import com.nopcommerce.demo.basepage.Basepage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class UtilityClass extends Basepage {

    // This method clicks on Element
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    //This method sends Key to Element
    public void sendTextToElements(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void sendTextToElements(WebElement element, String text) {
        element.sendKeys(text);
    }

    //This method gets text from Element
    public String getTextFromElements(By by) {
        return driver.findElement(by).getText();
    }

    public String getTextFromElements(WebElement element) {
        return element.getText();
    }

    //This method is used to select drop down using Index value.
    public void selectElementByIndex(By by, int index) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index);
    }

    public void selectElementByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }


    // This method is used to select drop down using Value
    public void selectElementByValue(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }

    public void selectElementByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    // This method is used to select drop down using String
    public void selectElementByVisibleString(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    public void selectElementByVisibleString(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);

    }

    // This method is used for Explicit wait - using WaitUntil - Element is Clickable
    public void waitUntilElementToBeClickable(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));

    }

    // This method is used for Explicit wait - using presence of Element Located by Locator
    public void waitUntilPresenceOfElementByLocator(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));

    }

    //This method is used for Explicit wait - using Visibility of element Located by Locator
    public void waitUntilVisibilityOfElementByLocator(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //This method is used for Fluent Wait

    public void fluentWait(int timeout){
        FluentWait <WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(timeout))
                .ignoring(NoSuchElementException.class);
    }


    // This method is used for Mouse Hover using move to element
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).perform();
    }

    public void mouseHoverToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    // This method is used for Mouse Hover using Mouse Element & click
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().perform();
    }

    public void mouseHoverToElementAndClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    //This method is used for Scroll down
    public void scrollDown(By by) {
        WebElement element = driver.findElement(by);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("windows.scrollBy(0,1200)");
    }

    //This method is used to generate Random String
    public void randomEmailGenerator(By by) {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        String randomEmail = "alphatest" + randomInt + "@gmail.com";
        driver.findElement(by).sendKeys(randomEmail);
    }

    //This method is used to generate Random number
    public int generateRandomNumber() {
        return (int) (Math.random() * 5000 + 1);
    }

    public void clearText(By by) {
        WebElement element = driver.findElement(by);
        element.clear();
    }

}
