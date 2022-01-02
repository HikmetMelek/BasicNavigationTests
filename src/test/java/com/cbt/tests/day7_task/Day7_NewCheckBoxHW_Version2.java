package com.cbt.tests.day7_task;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Day7_NewCheckBoxHW_Version2 {
/*
1. Go to
        http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
2. Login with-----Username: Tester, password: test
3. Click on check all button verify all the checkboxes are checked
4. Click on uncheck all button verify that all the checkboxes are unchecked
5. Select one of the checkbox and delete one person
6. Then verify that deleted item is no longer exists
 */
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= BrowserFactory.getDriver("chrome"); //1
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx"); //1

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester"); //2
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test"); //2
        driver.findElement(By.xpath("//input[@type='submit']")).click(); //2
        driver.manage().window().maximize();
        Thread.sleep(1000);

        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();//3 //click 'Check All' box

        List<WebElement> checkBoxes= driver.findElements(By.cssSelector("[type='checkbox']"));//3
        for (WebElement each: checkBoxes) {
            Assert.assertTrue(each.isSelected());
        }

        Thread.sleep(1000);

        driver.findElement(By.id("ctl00_MainContent_btnUncheckAll")).click(); //4
        checkBoxes= driver.findElements(By.cssSelector("[type='checkbox']"));
        for (WebElement each: checkBoxes) {
            Assert.assertFalse(each.isSelected());
        }

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[contains(@id,'orderGrid_ctl06')]")).click(); //5
        driver.findElement(By.cssSelector("input.btnDeleteSelected")).click(); //5
        Thread.sleep(1000);

        checkBoxes= driver.findElements(By.xpath("//div/table/tbody/tr/td[2]"));//6
        for (WebElement each: checkBoxes) {  //6
            Assert.assertFalse(each.getText().contains("Susan"));  //6
        }
        driver.quit();

    }
}
