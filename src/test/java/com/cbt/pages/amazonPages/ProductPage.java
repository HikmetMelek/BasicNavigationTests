package com.cbt.pages.amazonPages;

import com.cbt.utilities.ConfigurationReader;
import com.cbt.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProductPage extends BasePage{
    Select select;

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

    //@FindBy(id = "sc-subtotal-label-activecart")
    @FindBy(css = "span[class='a-dropdown-prompt']")
    public WebElement qtyOnCartPage;

    public void selectHat() {
        aHat.click();
    }

    public void changeQuantity(String quantity) throws InterruptedException {
        select = new Select(dropDownOfQty);
        select.selectByVisibleText(ConfigurationReader.get(quantity));
        Thread.sleep(1000);
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public void Verify_QtyAndPrice(String quantity)  {

        String qty = qtyOnCartPage.getText();
        int actual_qty = Integer.parseInt(qty);
        System.out.println(actual_qty);
        Assert.assertEquals(qty,ConfigurationReader.get(quantity), "quantities are not equal");

        String hatPrice = priceOfHat.getText();
        hatPrice = hatPrice.substring(1);

        double actualOneHatPrice = Double.parseDouble(hatPrice);
        System.out.println(actualOneHatPrice);

        double totalPriceOfHat = actual_qty * actualOneHatPrice;
        String expectedTotalPriceOfHat= Double.toString(totalPriceOfHat);

        String actualPrice = totalPrice.getText();
        actualPrice = actualPrice.substring(1);
        System.out.println(actualPrice);

        Assert.assertEquals(actualPrice, expectedTotalPriceOfHat, "prices are not equal");

    }



}
