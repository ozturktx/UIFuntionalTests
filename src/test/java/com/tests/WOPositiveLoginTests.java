package com.tests;

import com.utilities.BrowserUtils;
import com.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WOPositiveLoginTests extends TestBase {



    @Test
    public void titleTest()
    {
        Assert.assertTrue(BrowserUtils.verifyTextMatches(driver.getTitle(),"Web Orders Login"), "Expected title is Web Orders Login but was"+
                driver.getTitle());
        String expected="http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx";
        Assert.assertTrue(BrowserUtils.verifyTextMatches(driver.getCurrentUrl(),expected), "found url is "+
                driver.getCurrentUrl());
        login();
        Assert.assertTrue(BrowserUtils.verifyTextMatches(driver.getTitle(),"Web Orders"), "Expected title is Web Orders Login but was "+
                driver.getTitle());
    }


}
