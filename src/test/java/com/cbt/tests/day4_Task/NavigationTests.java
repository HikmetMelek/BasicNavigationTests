package com.cbt.tests.day4_Task;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {
    public static void main(String[] args) {
       differentBrowsers("Chrome");
       differentBrowsers("FireFox");
       differentBrowsers("Edge");

    }
    public static void differentBrowsers(String browser){
        WebDriver driver= BrowserFactory.getDriver(browser); //1
        //assert driver!=null;
        driver.get("https://google.com"); //2
        String expectedTitleGoogle= driver.getTitle(); //3

        driver.navigate().to("https://etsy.com"); //4
        String expectedTitleEtsy= driver.getTitle(); //5
        driver.navigate().back(); //6

        String actualTitleGoogle= driver.getTitle(); //7
        StringUtility.verifyEquals(expectedTitleGoogle,actualTitleGoogle); //7

        driver.navigate().forward(); //8
        String actualTitleEtsy= driver.getTitle(); //9
        StringUtility.verifyEquals(expectedTitleEtsy,actualTitleEtsy); //9

        driver.quit();
    }

}
