package com.nopcommerce.demo.basepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class Basepage {
    public static WebDriver driver;
    String baseUrl= "https://demo.nopcommerce.com/";
    String projectPath = System.getProperty("user.dir");


    public void selectBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            // Reporter.log("Launching Chrome browser");
            System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            //Reporter.log("Launching Firefox browser");
            System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            // Reporter.log("Launching IE browser");
            System.setProperty("webdriver.ie.driver", projectPath + "/drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else {
            System.out.println("Wrong browser name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);


    }
    public void closeBrowser(){
        if(driver!=null){
            driver.quit();
        }
    }
}