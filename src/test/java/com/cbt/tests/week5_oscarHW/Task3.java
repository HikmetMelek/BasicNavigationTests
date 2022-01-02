package com.cbt.tests.week5_oscarHW;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Task3 {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void Test3() throws InterruptedException {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");//1
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester"); //2
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test"); //2
        driver.findElement(By.xpath("//input[@type='submit']")).click(); //2
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Order")).click();

        WebElement product= driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        Select select= new Select(product);
        select.selectByVisibleText("MyMoney");
        String expectedProduct="MyMoney";
        String actualProduct= select.getFirstSelectedOption().getText();
        System.out.println("actualProduct = " + actualProduct);
        Assert.assertEquals(actualProduct,expectedProduct);

        select.selectByVisibleText("FamilyAlbum");
        WebElement txtQuantity= driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        txtQuantity.sendKeys("2");
        String quantity= txtQuantity.getAttribute("value");
        String pricePerUnit=driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice")).getAttribute("value");
    //     System.out.println("pricePerUnit = " + pricePerUnit);
        int total= Integer.parseInt(pricePerUnit)*Integer.parseInt(quantity);
    //    System.out.println("total = " + total);

        driver.findElement(By.cssSelector("input[value='Calculate']")).click();
        String expectedTotal= String.valueOf(total);
        String actualTotal= driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal")).getAttribute("value");
        Assert.assertEquals(actualTotal,expectedTotal);

    }
}
