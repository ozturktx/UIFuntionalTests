package com.tests;

import com.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WebOrders extends TestBase {
   public List<String> Names=new ArrayList<>();

@Test
    public void Products(){
    login();
driver.findElement(By.linkText("View all products")).click();
    List<WebElement> PNames=driver.findElements(By.xpath("//table[@class='ProductsTable']//tr//td[1]"));

    for (int i = 0; i < PNames.size(); i++) {
        Names.add(i,PNames.get(i).getText());
    }

    driver.findElement(By.linkText("View all orders")).click();
    List<WebElement> ProductOrders=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[3]"));

    boolean match=false;
    for (int i = 0; i < ProductOrders.size(); i++) {
        for (int j = 0; j < Names.size(); j++) {

              if(ProductOrders.get(i).getText().equals(Names.get(j)))
                 {
                      match=true;
                      break;
                 }
               }
              if (!match)
                  break;
            }
    Assert.assertTrue(match);
        }

        @Test
    public void createOrder() throws InterruptedException {

    login();
    driver.findElement(By.linkText("Order")).click();
    WebElement products=driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
            Select select=new Select(products);
            select.selectByIndex(random.nextInt(3));
            String name=fake.name().fullName();
            String cardNumber=fake.finance().creditCard().replace("-","");
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("1");
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(name);
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(fake.address().streetAddress());
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(fake.address().city());
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(fake.address().state());
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(fake.address().zipCode().substring(0,5));
            int numb=random.nextInt(3);
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_"+numb+"")).click();
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(cardNumber);
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("10/20");

            Thread.sleep(3000);
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
            driver.findElement(By.linkText("View all orders")).click();

            List<WebElement> AddedRow=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[2]"));
            for (WebElement a:AddedRow) {
                System.out.println(a.getText());
            }
Assert.assertTrue(AddedRow.get(0).getText().contains(name) &&AddedRow.get(0).getText().contains(cardNumber));

}

@Test
    public void Delete(){
    login();
    List<WebElement> rows=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr"));
    int rowCount=rows.size();
driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr["+random.nextInt((rowCount-2)+2)+"]//td[1]//input")).click();
    driver.findElement(By.name("ctl00$MainContent$btnDelete")).click();
    rows=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr"));
    Assert.assertTrue(rows.size()==rowCount-1);
}

    @Test
    public void Edit() throws InterruptedException {
        login();
        int rn=random.nextInt(8)+2;
        System.out.println(rn);
        List<String> row=new ArrayList<>();//driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr["+rn+"]"));
        for (int i = 0; i < 12; i++) {
            row.add(i,driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr["+rn+"]//td["+(i+2)+"]")).getText());
        }
/*
        for (String e:row) {
            System.out.println(e);
        }*/
        WebElement edit=driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr["+rn+"]//td[13]//input"));
        edit.click();
        WebElement quantity=driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        quantity.clear();
       // Thread.sleep(3000);
        quantity.sendKeys(Integer.toString(rn));
        driver.findElement(By.xpath("//*[@value='Calculate']")).click();
        Assert.assertEquals(quantity.getAttribute("value"),Integer.toString(rn));
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();
        WebElement Afteredit=driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr["+rn+"]//td[4]"));
        Assert.assertEquals(Afteredit.getText(),Integer.toString(rn));

        List<String> rowafter= new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            rowafter.add(i,driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr["+rn+"]//td["+(i+2)+"]")).getText());
        }
        for (int i=0;i<row.size();i++) {
            if(i==2)
                continue;
            Assert.assertEquals(row.get(i),rowafter.get(i));
        }

    }
}




