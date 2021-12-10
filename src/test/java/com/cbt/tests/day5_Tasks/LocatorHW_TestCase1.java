package com.cbt.tests.day5_Tasks;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LocatorHW_TestCase1 {
    public static void main(String[] args) {
/*
1.Go to Ebay // https://www.ebay.com/
2.enter search term
3.click on search button
4.print number of results
 */
        // Test Case 1:
        WebDriver driver= BrowserFactory.getDriver("chrome"); //1
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/"); //1
        driver.findElement(By.id("gh-ac")).sendKeys("watch"); //2
        driver.findElement(By.xpath("//input[@value='Search']")).click(); //3
        String resultNumber= driver.findElement(By.xpath("//span[@class='BOLD']/parent::h1/span")).getText();//4
        System.out.println("result = " + resultNumber); //4
        driver.quit();


    }
}
