package com.cbt.tests.day9_tasks;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HW2_07 {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");//1
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

        @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
/*
Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
Step 2. And click on “File Upload".
Step 3. Upload any file with .txt extension from your
computer.
Step 4. Click “Upload” button.
Step 5. Verify that subject is: “File Uploaded!”
Step 6. Verify that uploaded file name is displayed
 */
        driver.findElement(By.linkText("File Upload")).click();//2
        WebElement chosenFile = driver.findElement(By.id("file-upload"));//3
        chosenFile.sendKeys("C:\\Users\\Melek\\Desktop\\file.txt");//3
        Thread.sleep(1000);
        driver.findElement(By.id("file-submit")).click();//4
        String actual= driver.findElement(By.cssSelector("div[class='example']>h3")).getText();
        Assert.assertEquals(actual,"File Uploaded!");//5

        String fileName= driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(fileName,"file.txt");






    }
}
