package com.tests;

import com.utilities.BrowserUtils;
import com.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
public class WONegativeLoginTests extends TestBase {

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
       login();
        Assert.assertTrue(BrowserUtils.verifyTextMatches(driver.getTitle(),"Web Orders Login"), "Expected title is Web Orders Login but was"+
                driver.getTitle());
        Assert.assertTrue(BrowserUtils.verifyTextMatches(driver.getCurrentUrl(),url), "found url is "+
                driver.getCurrentUrl());
        Assert.assertTrue(BrowserUtils.verifyTextMatches(driver.getTitle(),"Web Orders Login"), "Expected title is Web Orders Login but was"+
                driver.getTitle());

        driver.findElement(By.id("ctl00_MainContent_username")).clear();
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("tester");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        Assert.assertTrue(BrowserUtils.verifyTextMatches(driver.getTitle(),"Web Orders Login"), "Expected title is Web Orders Login but was"+
                driver.getTitle());
        Assert.assertTrue(BrowserUtils.verifyTextMatches(driver.getCurrentUrl(),url), "found url is "+
                driver.getCurrentUrl());

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).clear();
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        Assert.assertTrue(BrowserUtils.verifyTextMatches(driver.getTitle(),"Web Orders Login"), "Expected title is Web Orders Login but was"+
                driver.getTitle());
        Assert.assertTrue(BrowserUtils.verifyTextMatches(driver.getCurrentUrl(),url), "found url is "+
                driver.getCurrentUrl());
    }

}
