package com.utilities;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    public WebDriver driver;
    protected SoftAssert softAssert;
    protected Actions action;
    public Faker fake;
    public String url="http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx";
    public Random random;
    @BeforeClass
    public void setUpClass()
    {
        WebDriverManager.chromedriver().setup();
    }

    public void login()
    {
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
    }
    @BeforeMethod
    public void setUp()
    {
        random=new Random();
        fake=new Faker();
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        action= new Actions(driver);
        softAssert=new SoftAssert();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
        softAssert.assertAll();
    }
}