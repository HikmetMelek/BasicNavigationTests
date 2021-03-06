package com.cbt.pages.amazonPages;

import com.cbt.utilities.ConfigurationReader;
import com.cbt.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage_amazon {

    public BasePage_amazon(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchInputBox;

    @FindBy(css = "div.nav-search-submit.nav-sprite")
    public WebElement searchButton;

    @FindBy(id = "nav-cart")
    public WebElement Cart;

    public void searchForHat() {
        searchInputBox.sendKeys(ConfigurationReader.get("productHat"));
        searchButton.click();

    }

    public void goToCart() {
        Cart.click();
    }

}
