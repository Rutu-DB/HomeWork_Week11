package com.nopcommerce.demo.testbase;

import com.nopcommerce.demo.utility.UtilityClass;
import org.junit.Before;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase extends UtilityClass {

    String browser = "chrome";

    @BeforeMethod
    public void setUp(){
        selectBrowser(browser);
    }
    @AfterMethod
    public void tearDown(){
//        closeBrowser();
    }
}
