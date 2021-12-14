package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day7_NewCheckBoxHW {
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

        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();//3
        Assert.assertTrue(driver.findElement(By.xpath("//input[contains(@id,'orderGrid_ctl02')]")).isSelected(), "verify Paul checked");
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='orderGrid_ctl03']")).isSelected(), "verify Mark checked");
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='orderGrid_ctl04']")).isSelected(), "verify Steve checked");
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='orderGrid_ctl05']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='orderGrid_ctl06']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='orderGrid_ctl07']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='orderGrid_ctl08']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='orderGrid_ctl09']")).isSelected());
        Thread.sleep(1000);

        driver.findElement(By.id("ctl00_MainContent_btnUncheckAll")).click(); //4
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='orderGrid_ctl02']")).isSelected(), "Paul checkbox unselected");
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='orderGrid_ctl02']")).isSelected(), "Mark checkbox unselected");
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='orderGrid_ctl02']")).isSelected(), "Steve checkbox unselected");
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='orderGrid_ctl02']")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='orderGrid_ctl02']")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='orderGrid_ctl02']")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='orderGrid_ctl02']")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='orderGrid_ctl02']")).isSelected());
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[contains(@id,'orderGrid_ctl06')]")).click(); //5
        WebElement deletedButton= driver.findElement(By.xpath("//div/table/tbody/tr[6]/td[2]"));//5 to verify
        String expectedText= deletedButton.getText();//5 to verify
        System.out.println("expectedText = " + expectedText);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input.btnDeleteSelected")).click(); //5
        Thread.sleep(1000);

        WebElement newButton6= driver.findElement(By.xpath("//div/table/tbody/tr[6]/td[2]"));//6 to verify
        String actualText= newButton6.getText(); //6 to verify
        System.out.println("actualText = " + actualText);

        Assert.assertFalse(actualText.equals(expectedText),"susan bob does not mach"); //6

        driver.quit();

    }
}
