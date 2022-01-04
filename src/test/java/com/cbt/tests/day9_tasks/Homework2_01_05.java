package com.cbt.tests.day9_tasks;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Homework2_01_05 {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");//1
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void Test1(){
    /*
Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter “wrong_dob” into date of birth input box.
Step 4. Verify that warning message is displayed: “The date of birth is not valid”
         */

        driver.findElement(By.linkText("Registration Form")).click();//2
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("12/05");//3
        String expectedText= "The date of birth is not valid";
        System.out.println("expectedText = " + expectedText);
        String actualText= driver.findElement(By.xpath("//small[contains(text(),'The date of birth is not valid')]")).getText();
        System.out.println("actualText = " + actualText);
        Assert.assertEquals(actualText,expectedText);//4
    }

    @Test
    public void Test2(){
        /*
Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Verify that following options for programming languages are displayed: c++, java,JavaScript
         */

        driver.findElement(By.linkText("Registration Form")).click();//2
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='C++']")).isDisplayed(), "C++ is not displayed"); //3
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Java']")).isDisplayed(), "Java is not displayed"); //3
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='JavaScript']")).isDisplayed(), "JavaScript is not displayed"); //3

    }

    @Test
    public void Test3(){
        /*
Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter only one alphabetic character into first name input box.
Step 4. Verify that warning message is displayed: “first name must be more than 2 and less than 64 characters long”
         */

        driver.findElement(By.linkText("Registration Form")).click();//2
        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("A");//3
        String expectedWarning= "first name must be more than 2 and less than 64 characters long";
        String actualWarning= driver.findElement(By.xpath("//small[contains(text(),'2 and less than 64 ch')]")).getText();
        System.out.println("actualWarning = " + actualWarning);
        Assert.assertEquals(actualWarning,expectedWarning); //4

    }

    @Test
    public void Test4(){
        /*
Step 1. Go to https://practice-cybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter only one alphabetic character into last name input box.
Step 4. Verify that warning message is displayed:“The last name must be more than 2 and less than 64 characters long”
         */

        driver.findElement(By.linkText("Registration Form")).click();//2
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("S");//3
        String expectedWarning= "The last name must be more than 2 and less than 64 characters long";
        String actualWarning= driver.findElement(By.xpath("//small[contains(text(),'The last name must be more ' )]")).getText();
        Assert.assertEquals(actualWarning,expectedWarning); //4
    }
    @Test
    public void Test5() {
        /*
Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter any valid first name.
Step 4. Enter any valid last name.
Step 5. Enter any valid username.
Step 6. Enter any valid password.
Step 7. Enter any valid phone number.
Step 8. Select gender.
Step 9. Enter any valid date of birth.
Step 10. Select any department.
Step 11. Enter any job title.
Step 12. Select java as a programming language.
Step 13. Click Sign up.
Step 14. Verify that following success message is
displayed: “You've successfully completed registration!”
Note: for using dropdown, please refer to the documentation: https://selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/
Select.html or, please watch short video about drop-downs that is posted on canvas.
         */

        driver.findElement(By.linkText("Registration Form")).click();//2
        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Nicole");//3
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Sun");//4
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("nclsun");//5
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("nicolemelek@gmail.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("12345678");//6
        driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("571-258-4789");//7
        driver.findElement(By.cssSelector("input[value='female']")).click();//8
        driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("02/25/1995");//9

        WebElement department= driver.findElement(By.cssSelector("select[name='department']"));//10
        Select departmentDropdown= new Select(department);
        departmentDropdown.selectByVisibleText("Department of Agriculture");
        //System.out.println(departmentDropdown.getFirstSelectedOption().getText());

        WebElement jobTitle= driver.findElement(By.cssSelector("select[name='job_title']"));//11
        Select jobDropdown= new Select(jobTitle);
        jobDropdown.selectByVisibleText("Designer");

        driver.findElement(By.cssSelector("#inlineCheckbox2")).click();//12
   //     System.out.println(driver.findElement(By.cssSelector("#inlineCheckbox2")).getAttribute("outerHTML"));
        driver.findElement(By.cssSelector("#wooden_spoon")).click();//13

        String expectedMessage= "You've successfully completed registration!"; //14
        System.out.println("expectedMessage = " + expectedMessage);
        String actualMessage= driver.findElement(By.xpath("//p[contains(text(),\"You've successfully completed registration!\")]")).getText();//14
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals(actualMessage,expectedMessage); //14
    }
}
