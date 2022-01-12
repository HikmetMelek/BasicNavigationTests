package com.cbt.tests.day9_tasks;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HW9_12 {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");//1
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Status Codes")).click();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }


    @Test
    public void test1()  {

        String[] statusCodes = {"200", "301", "404", "500"};

        for (int i = 0; i < statusCodes.length; i++) {
            driver.findElement(By.linkText(statusCodes[i])).click();

            String text = driver.findElement(By.xpath("//div[@class='example']//p")).getText();

            String[] arr = text.split("\n");
            Assert.assertTrue(arr[0].contains("This page returned a " + statusCodes[i] + " status code."));

            driver.navigate().back();
        }
    }


    @Test
    public void test2() throws InterruptedException { // Ahmet solution

        List<WebElement> elements = driver.findElements(By.xpath("//*[@id='example']/div//a"));
        System.out.println(elements.size());

        for (int i = 0; i < elements.size(); i++) {
            WebElement each = driver.findElement(By.xpath("(//*[@id='example']/div//a)[" + (i + 1) + "]"));
            String control = each.getText();
            each.click();
            String actual = driver.findElement(By.xpath("//h3/../p")).getText();
            Assert.assertTrue(actual.contains(control));
            driver.navigate().back();
        }
    }


   @DataProvider(name = "status_codes")
    public Object[][] provider(){
        return new Object[][] {{"200"}, {"301"}, {"404"}, {"500"}};
    }
    @Test(dataProvider = "status_codes")
    public void test3(String linkValue){

        driver.findElement(By.linkText(linkValue)).click();
        String text = driver.findElement(By.xpath("//h3/../p")).getText();
        String[] textLine = text.split("\n");
        String expectedTextLine = "This page returned a "+linkValue+" status code.";
        Assert.assertEquals(expectedTextLine,textLine[0]);

    }

}
