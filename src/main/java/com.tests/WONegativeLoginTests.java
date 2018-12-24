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

public class WONegativeLoginTests {
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
    public void NegativeLoginTestWrongUsername()
    {

        Assert.assertTrue(BrowserUtils.verifyTextMatches(driver.getTitle(),"Web Orders Login"), "Expected title is Web Orders Login but was"+
                driver.getTitle());
        String url=driver.getCurrentUrl();
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tes");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        Assert.assertTrue(BrowserUtils.verifyTextMatches(driver.getTitle(),"Web Orders Login"), "Expected title is Web Orders Login but was"+
                driver.getTitle());
        Assert.assertTrue(BrowserUtils.verifyTextMatches(driver.getCurrentUrl(),url), "found url is "+
                driver.getCurrentUrl());

    }
    @Test
    public void NegativeLoginTestWrongPassword()
    {

        Assert.assertTrue(BrowserUtils.verifyTextMatches(driver.getTitle(),"Web Orders Login"), "Expected title is Web Orders Login but was"+
                driver.getTitle());
        String url=driver.getCurrentUrl();
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("tester");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        Assert.assertTrue(BrowserUtils.verifyTextMatches(driver.getTitle(),"Web Orders Login"), "Expected title is Web Orders Login but was"+
                driver.getTitle());
        Assert.assertTrue(BrowserUtils.verifyTextMatches(driver.getCurrentUrl(),url), "found url is "+
                driver.getCurrentUrl());

    }
    @Test
    public void NegativeLoginTestBlankUsername()
    {

        Assert.assertTrue(BrowserUtils.verifyTextMatches(driver.getTitle(),"Web Orders Login"), "Expected title is Web Orders Login but was"+
                driver.getTitle());
        String url=driver.getCurrentUrl();
       // driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("tester");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        Assert.assertTrue(BrowserUtils.verifyTextMatches(driver.getTitle(),"Web Orders Login"), "Expected title is Web Orders Login but was"+
                driver.getTitle());
        Assert.assertTrue(BrowserUtils.verifyTextMatches(driver.getCurrentUrl(),url), "found url is "+
                driver.getCurrentUrl());

    }
    @Test
    public void NegativeLoginTestBlankPassword()
    {

        Assert.assertTrue(BrowserUtils.verifyTextMatches(driver.getTitle(),"Web Orders Login"), "Expected title is Web Orders Login but was"+
                driver.getTitle());
        String url=driver.getCurrentUrl();
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        //driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("tester");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        Assert.assertTrue(BrowserUtils.verifyTextMatches(driver.getTitle(),"Web Orders Login"), "Expected title is Web Orders Login but was"+
                driver.getTitle());
        Assert.assertTrue(BrowserUtils.verifyTextMatches(driver.getCurrentUrl(),url), "found url is "+
                driver.getCurrentUrl());

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
