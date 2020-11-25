package com.nopcommerce.demo.testSuite;

import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
// Test Case to verify Login Link is clickable
    public void verifyLoginLink(){
        clickOnElement(By.xpath("//a[contains(text(),'Log in')]"));
    }

    // Test case to verify that Login functionality if the login is unsuccessful

    @Test
    public void loginUsingInvalidCredentials() throws InterruptedException {
        // Holds the process for 20 Seconds for execution
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[contains(text(),'Log in')]"));
        clickOnElement(By.cssSelector("#Email"));
        Thread.sleep(2000);
        sendTextToElements(By.cssSelector("#Email"), "johnsmith1@gmail.com.com");
        clickOnElement(By.name("Password"));
        sendTextToElements(By.name("Password"), "abcd1234");
        clickOnElement(By.xpath("//input[@value='Log in']"));
        String actualMessage = getTextFromElements(By.xpath("//div[@class = 'message-error validation-summary-errors']"));
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void loginUsingValidCredentials () throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[contains(text(),'Log in')]"));
        clickOnElement(By.cssSelector("#Email"));
        Thread.sleep(2000);
        sendTextToElements(By.cssSelector("#Email"), "alphatest@gmail.com");
        clickOnElement(By.name("Password"));
        sendTextToElements(By.name("Password"), "123456");
        clickOnElement(By.xpath("//input[@value='Log in']"));
        String actualMessage = getTextFromElements(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        String expectedMessage = "Welcome to our store";
        Assert.assertEquals(actualMessage,expectedMessage);
    }
}
