package com.cbt.tests.day5_Tasks;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LocatorHW_TestCase3 {
    public static void main(String[] args) {
/*
1.Go to wikipedia.org // https://www.wikipedia.org/
2.enter search term `selenium webdriver`
3.click on search button
4.click on search result `Selenium (software)`
5.verify url ends with `Selenium_(software)'
 */
        // Test Case 3:
        WebDriver driver= BrowserFactory.getDriver("chrome"); //1
        driver.get("https://www.wikipedia.org/"); //1
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver"); //2
        driver.findElement(By.xpath("//button[@class='pure-button pure-button-primary-progressive']")).click(); //3
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@title='Selenium (software)']")).click();//4
        String actualUrl= driver.getCurrentUrl();//5
        String expectedUrlEndsWith= "Selenium_(software)";//5

        if(actualUrl.endsWith(expectedUrlEndsWith)) System.out.println("PassUrl");//5
        else System.out.println("FailUrl");//5

        driver.quit();

    }
}
