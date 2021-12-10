package com.cbt.tests.day5_Tasks;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LocatorHW2 {
    public static void main(String[] args) throws InterruptedException {
 /*
XPATH PRACTICES ! DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/forgot_password     Links to an external site.
3. Locate all the WebElements on the page using XPATH locator only (total of 6)
   a. “Home” link
   b. “Forgot password” header
   c. “E-mail” text
   d. E-mail input box
   e. “Retrieve password” button
4.Print text of a,b,c,e and put some email to d
  */
        WebDriver driver= BrowserFactory.getDriver("chrome");//1
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");//2

        String homeText= driver.findElement(By.xpath("//a[@class='nav-link']")).getText();//3.a.
        System.out.println("homeText = " + homeText);

        String forgotPasswordText= driver.findElement(By.xpath("//h2[text()='Forgot Password']")).getText();//3.b.
        System.out.println("forgotPasswordText = " + forgotPasswordText);

        String emailText= driver.findElement(By.xpath("//label[@for='email']")).getText();//3.c.
        System.out.println("emailText = " + emailText);

        String retrievePasswordText= driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']")).getText();//3.e.
        System.out.println("retrievePasswordText = " + retrievePasswordText);

        driver.findElement(By.xpath("//input[@type='text'][@name='email']")).sendKeys("Miketest@cyber.com");//3.d

        Thread.sleep(3000);
        driver.quit();

    }
}
