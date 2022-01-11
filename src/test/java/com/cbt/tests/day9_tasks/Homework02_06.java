package com.cbt.tests.day9_tasks;

import com.cbt.utilities.BrowserFactory;
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

public class Homework02_06 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("https://www.tempmailaddress.com/");//1
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
      //  driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        /*
Step 1. Go to "https://www.tempmailaddress.com/"
Step 2. Copy and save email as a string.
Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”
Step 4. And click on “Sign Up For Mailing List".
Step 5. Enter any valid name.
Step 6. Enter email from the Step 2.
Step 7. Click Sign Up
Step 8. Verify that following message is displayed:“Thank you for signing up. Click the button below to return to the home page.”
Step 9. Navigate back to the “https://www.tempmailaddress.com/”
Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
Step 11. Click on that email to open it.
Step 12. Verify that email is from: “do-not-reply@practice.cybertekschool.com”
Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
         */

        driver.findElement(By.cssSelector("a[href='#copy']")).click();//2
        String fakeEmail=driver.findElement(By.cssSelector("span[class='animace']")).getText();//2
        Thread.sleep(1000);
        driver.get("https://practice-cybertekschool.herokuapp.com");//3
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();//4
        driver.findElement(By.cssSelector("input[name='full_name']")).sendKeys("Nicole");//5
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys(fakeEmail);//6
        driver.findElement(By.cssSelector("button[name='wooden_spoon']")).click();//7
        String actualMessage= driver.findElement(By.cssSelector("h3[name='signup_message']")).getText();//8
        String expectedMessage= "Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals(actualMessage,expectedMessage);//8
        driver.navigate().to("https://www.tempmailaddress.com/");//9

        WebElement mail= driver.findElement(By.xpath("//*[@id='schranka']/tr[1]/td[1]"));//String receivedText = driver.findElement(By.xpath("//*[contains(.,'do-not-reply')]")).getText();
                                                                                                         // Assert.assertTrue(receivedText.contains("do-not-reply@practice.cybertekschool.com"));
    //    WebDriverWait wait= new WebDriverWait(driver,59);
   //     wait.until(ExpectedConditions.visibilityOf(mail));
        String actualMail= mail.getText().trim();
        System.out.println("actualMail = " + actualMail);
        String expectedMail= "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(actualMail,expectedMail);//10

        mail.click();//11

        String actualFrom= driver.findElement(By.id("odesilatel")).getText().trim();//12
        String expectedFrom="do-not-reply@practice.cybertekschool.com";//12
        Assert.assertEquals(actualFrom,expectedFrom);//12

        String actualSubject= driver.findElement(By.id("predmet")).getText().trim();//13
        String expectedSubject="Thanks for subscribing to practice.cybertekschool.com!";//13
        Assert.assertEquals(actualSubject,expectedSubject);//13

    }

}
