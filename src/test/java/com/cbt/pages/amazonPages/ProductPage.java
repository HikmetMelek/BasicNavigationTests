package com.cbt.pages.amazonPages;

import com.cbt.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage{

    public ProductPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//span[contains(text(),'Champion Ameritage Dad Adjustable Cap')]")
    public WebElement aHat;

    @FindBy(id ="add-to-cart-button")
    public WebElement addToCartButton;

    @FindBy(id = "quantity")
    public WebElement dropDownOfQty;

    @FindBy(css = "p.a-spacing-mini>span")
    public WebElement priceOfHat;

    @FindBy(xpath = "//span[@id='sc-subtotal-amount-activecart']/span")
    public WebElement totalPrice;

    @FindBy(id = "sc-subtotal-label-activecart")
    public WebElement qtyOnCartPage;



}
