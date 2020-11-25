package com.nopcommerce.demo.testSuite;

import com.nopcommerce.demo.testbase.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestSuiteClass extends TestBase {

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]"));
        Thread.sleep(500);
        clickOnElement(By.xpath("//h2[@class='title']//a[contains(text(),'Desktops')]"));
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        selectElementByVisibleString(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");


        String expectedResult1 = getTextFromElements(By.xpath("//a[contains(text(),'Lenovo IdeaCentre 600 All-in-One PC')]"));
        String expectedResult2 = getTextFromElements(By.xpath("//a[contains(text(),'Digital Storm VANQUISH 3 Custom Performance PC')]"));
        String expectedResult3 = getTextFromElements(By.xpath("//a[contains(text(),'Build your own computer')]"));

        Assert.assertEquals(expectedResult1, "Lenovo IdeaCentre 600 All-in-One PC");
        Assert.assertEquals(expectedResult2, "Digital Storm VANQUISH 3 Custom Performance PC");
        Assert.assertEquals(expectedResult3, "Build your own computer");

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        String expectedResult;
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//h2[@class='title']//a[contains(text(),'Desktops')]"));
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        selectElementByVisibleString(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");

        clickOnElement(By.xpath("//body/div[6]/div[3]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/input[1]"));

        expectedResult = getTextFromElements(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        Assert.assertEquals(expectedResult, "Build your own computer");

        clickOnElement(By.xpath("//select[@id='product_attribute_1']"));
        Thread.sleep(200);
        selectElementByIndex(By.xpath("//select[@id='product_attribute_1']"), 0);
       Thread.sleep(200);

        clickOnElement(By.xpath("//select[@id='product_attribute_2']"));
        selectElementByVisibleString(By.xpath("//select[@id='product_attribute_2']"), "8GB [+$60.00]");

        clickOnElement(By.xpath("//dd[@id='product_attribute_input_4']//li[2]//label[contains(text(),'Vista Premium [+$60.00]')]"));
        Thread.sleep(500);
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        Thread.sleep(500);

        mouseHoverToElement(By.xpath("//input[@id='product_attribute_5_10']"));
        Thread.sleep(500);
        mouseHoverToElementAndClick(By.xpath("//input[@id='product_attribute_5_12']"));
        Thread.sleep(500);

        expectedResult = getTextFromElements(By.xpath("//span[@id='price-value-1']"));
        Assert.assertEquals(expectedResult, "$1,475.00");
        Thread.sleep(200);

        clickOnElement(By.xpath("//input[@id='add-to-cart-button-1']"));
        Thread.sleep(200);

        expectedResult = getTextFromElements(By.xpath("//body/div[@id='bar-notification']/div[1]"));
        Assert.assertEquals(expectedResult, "The product has been added to your shopping cart");

        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        Thread.sleep(200);

        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//div[@class='mini-shopping-cart']//div//input"));
        Thread.sleep(500);
        expectedResult = getTextFromElements(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals(expectedResult, "Shopping cart");

        clickOnElement(By.className("qty-input"));
        clearText(By.className("qty-input"));
        sendTextToElements(By.className("qty-input"), "2");
        clickOnElement(By.xpath("//div[@class='cart-options']//div//input[@class='button-2 update-cart-button']"));

       Assert.assertEquals(getTextFromElements(By.className("product-subtotal")),"$2,950.00");

    }
}
