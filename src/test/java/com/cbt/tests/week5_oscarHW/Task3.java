package com.cbt.tests.week5_oscarHW;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task3 {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
    @Test
    public void Test() throws InterruptedException {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");//1
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester"); //2
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test"+ Keys.ENTER); //2 Keys.ENTER: click enter

        Thread.sleep(2000);
        driver.findElement(By.linkText("Order")).click(); //3

        WebElement product= driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")); //4
        Select select= new Select(product); //4
        String expectedProduct="MyMoney"; //4
        String actualProduct= select.getFirstSelectedOption().getText(); //4
        System.out.println("actualProduct = " + actualProduct); //4
        Assert.assertEquals(actualProduct,expectedProduct); //4

        select.selectByVisibleText("FamilyAlbum"); //5
        WebElement txtQuantity= driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));//5
        txtQuantity.sendKeys("2");//5
        driver.findElement(By.cssSelector("input[value='Calculate']")).click();//5

        String quantity= txtQuantity.getAttribute("value");//6
        String pricePerUnit=driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice")).getAttribute("value");//6
        int total= Integer.parseInt(pricePerUnit) * Integer.parseInt(quantity);//6
        String expectedTotal= String.valueOf(total); //6 // Integer.toString(total);
        String actualTotal= driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal")).getAttribute("value");//6
        Assert.assertEquals(actualTotal,expectedTotal); //6

// Zikrillo solution:
        /*
        int total = Integer.parseInt(quantityInput.getAttribute("value")) * Integer.parseInt(priceInput.getAttribute("value"));
        Assert.assertEquals(totalInput.getAttribute("value"), Integer.toString(total), "Calculation failed");
         */
    }
}
