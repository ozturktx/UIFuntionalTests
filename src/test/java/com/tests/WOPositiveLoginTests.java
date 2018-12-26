package com.tests;

import com.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WOPositiveLoginTests {

    WebDriver driver;
    @BeforeMethod
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/\n" +
                "login.aspx");
    }
    @Test
    public void titleTest()
    {
        Assert.assertTrue(BrowserUtils.verifyTextMatches(driver.getTitle(),"Web Orders Login"), "Expected title is Web Orders Login but was"+
                driver.getTitle());
        String expected="http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";
        Assert.assertTrue(BrowserUtils.verifyTextMatches(driver.getCurrentUrl(),expected), "found url is "+
                driver.getCurrentUrl());

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        Assert.assertTrue(BrowserUtils.verifyTextMatches(driver.getTitle(),"Web Orders"), "Expected title is Web Orders Login but was "+
                driver.getTitle());
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
