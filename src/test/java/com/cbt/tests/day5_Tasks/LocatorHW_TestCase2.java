package com.cbt.tests.day5_Tasks;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LocatorHW_TestCase2 {
    public static void main(String[] args) {
 /*
1.Go to Ebay//https://www.ebay.com/
2.search Selenium
3.click on search button
4.verify title contains Selenium
  */
        // Test Case 2:
        WebDriver driver= BrowserFactory.getDriver("edge");//1
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");//1
        driver.findElement(By.id("gh-ac")).sendKeys("Selenium");//2
        driver.findElement(By.xpath("//input[@value='Search']")).click(); //3
        String resultText= driver.findElement(By.xpath("//span[@class='BOLD']/parent::h1/span[2]")).getText();//4
        resultText= resultText.toLowerCase(); //4
        String expectedText="Selenium"; //4
        expectedText=expectedText.toLowerCase(); //4
        System.out.println("resultText = " + resultText);
        System.out.println("expectedText = " + expectedText);
        if(resultText.contains(expectedText)) System.out.println("PASS"); //4
        else System.out.println("FAIL"); //4

        driver.quit();
    }
}

