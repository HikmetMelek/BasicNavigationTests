package com.cbt.tests.reviewWeekTasks;

import com.cbt.pages.moneyGamingPages.DashboardPageGame;
import com.cbt.pages.moneyGamingPages.RegistrationPageGame;
import com.cbt.tests.TestBase_MoneyGaming;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task2_MoneyGaming extends TestBase_MoneyGaming {

@Test
    public void joinMoneyGaming(){
    new DashboardPageGame().joinButton.click();
    RegistrationPageGame infoPage= new RegistrationPageGame();
    select= new Select(infoPage.titleDropdown);
    select.selectByValue("Ms");
    infoPage.firstNameBox.sendKeys("Mary");
    infoPage.surnameBox.sendKeys("Smith");
    infoPage.over18Checkbox.click();
    infoPage.submitButton.click();

    String expectedErrorText= "This field is required";
    String actualErrorText= infoPage.error.getText();

    Assert.assertEquals(actualErrorText,expectedErrorText);


}




}
