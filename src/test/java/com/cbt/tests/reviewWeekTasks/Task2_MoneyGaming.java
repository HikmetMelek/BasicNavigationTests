package com.cbt.tests.reviewWeekTasks;

import com.cbt.pages.moneyGamingPages.DashboardPage;
import com.cbt.pages.moneyGamingPages.RegistrationPage;
import com.cbt.tests.TestBase_MoneyGaming;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Task2_MoneyGaming extends TestBase_MoneyGaming {

@Test
    public void test(){
    DashboardPage dashboardPage= new DashboardPage();
    dashboardPage.joinButton.click();
    RegistrationPage infoPage= new RegistrationPage();
    select= new Select(infoPage.titleDropdown);
    select.selectByValue("Ms");
}




}
