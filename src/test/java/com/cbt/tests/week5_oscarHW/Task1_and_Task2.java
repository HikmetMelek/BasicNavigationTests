package com.cbt.tests.week5_oscarHW;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task1_and_Task2 {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        // implicitly wait, this is going to be applied to whole test cases and elements
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");//1
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void Test1() throws InterruptedException {

        driver.findElement(By.id("alert")).click();//2

        WebDriverWait wait= new WebDriverWait(driver,10); //3
        wait.until(ExpectedConditions.alertIsPresent()); //3
        // handle javascript alert
        // if you don't wait you will get NoAlertPresentException: no such alert
        Alert alert= driver.switchTo().alert(); //4
        Thread.sleep(2000);
        alert.accept(); //4
    }

    @Test
    public void Test2(){

        WebElement button= driver.findElement(By.id("disable"));// before 4 condition
        Assert.assertFalse(button.isEnabled()); // before 4 condition

        driver.findElement(By.id("enable-button")).click();//2

        WebDriverWait wait= new WebDriverWait(driver,11);//3
        wait.until(ExpectedConditions.elementToBeClickable(button));//3
        Assert.assertTrue(button.isEnabled()); //4

    }

}
