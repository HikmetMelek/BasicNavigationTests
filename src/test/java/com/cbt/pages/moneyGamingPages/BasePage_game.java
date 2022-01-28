package com.cbt.pages.moneyGamingPages;

import com.cbt.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage_game {
    public BasePage_game(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = "a.newUser.green")
    public WebElement joinButton;
}
