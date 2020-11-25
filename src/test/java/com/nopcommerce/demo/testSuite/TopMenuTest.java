package com.nopcommerce.demo.testSuite;

import com.nopcommerce.demo.testbase.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TopMenuTest extends TestBase {
    static String expText;

    @Test
    public void verifyPageNavigation() throws InterruptedException {
        selectMenu("Computers");
        Thread.sleep(500);
        expText = "Computers";
        Assert.assertEquals(expText, getTextFromElements(By.xpath("//h1[contains(text(),'Computers')]")));

        selectMenu("Electronics");
        Thread.sleep(500);
        expText = "Electronics";
        Assert.assertEquals(expText, getTextFromElements(By.xpath("//h1[contains(text(),'Electronics')]")));

        selectMenu("Apparel");
        Thread.sleep(500);
        expText = "Apparel";
        Assert.assertEquals(expText, getTextFromElements(By.xpath("//h1[contains(text(),'Apparel')]")));

        selectMenu("Digital downloads");
        Thread.sleep(500);
        expText = "Digital downloads";
        Assert.assertEquals(expText, getTextFromElements(By.xpath("//h1[contains(text(),'Digital downloads')]")));

        selectMenu("Books");
        Thread.sleep(500);
        expText = "Books";
        Assert.assertEquals(expText, getTextFromElements(By.xpath("//h1[contains(text(),'Books')]")));

        selectMenu("Jewelry");
        Thread.sleep(500);
        expText = "Jewelry";
        Assert.assertEquals(expText, getTextFromElements(By.xpath("//h1[contains(text(),'Jewelry')]")));

        selectMenu("Gift Cards");
        Thread.sleep(500);
        expText = "Gift Cards";
        Assert.assertEquals(expText, getTextFromElements(By.xpath("//h1[contains(text(),'Gift Cards')]")));
    }
//parameterised Method - Select Menu
    public void selectMenu(String menu) {
        //Stored all elements from header in allLink list
        List<WebElement> allLinks = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']//a"));
        // For each iterates allLinks fetched by WebElement
        for (WebElement links : allLinks) {
            // using if statement it verifies each elements. It matches all selection from VerificationMethod
            if (links.getText().contains(menu)) {
                clickOnElement(By.xpath("//div/ul[@class= 'top-menu notmobile']//a[contains(text(),'" + menu + "')]"));
                break;
            }
        }
    }
}

