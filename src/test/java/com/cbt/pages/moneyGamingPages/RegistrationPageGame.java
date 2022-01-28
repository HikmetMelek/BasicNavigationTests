package com.cbt.pages.moneyGamingPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPageGame extends BasePage_game {

    @FindBy(id = "title")
    public WebElement titleDropdown;

    @FindBy(name = "map(firstName)")
    public WebElement firstNameBox;

    @FindBy(name = "map(lastName)")
    public WebElement surnameBox;//map(terms)

    @FindBy(name = "map(terms)")
    public WebElement over18Checkbox;

    @FindBy(id = "form")
    public WebElement submitButton;

    @FindBy(css = "label[for='dob']")
    public WebElement error;

}