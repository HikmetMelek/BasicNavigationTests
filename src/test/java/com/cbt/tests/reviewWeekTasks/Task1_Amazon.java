package com.cbt.tests.reviewWeekTasks;

import com.cbt.pages.amazonPages.ProductPage;
import com.cbt.tests.TestBase_Amazon;
import com.cbt.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task1_Amazon extends TestBase_Amazon {
/*
1.	Go to https://www.amazon.com
2.	Search for "hats for men" (Call from Configuration.properties file)
3.	Add the first hat appearing to Cart with quantity 2
4.	Open cart and assert that the total price and quantity are correct
5.	Reduce the quantity from 2 to 1 in Cart for the item selected in the step 3
6.	Assert that the total price and quantity has been correctly changed
 The goal of this test is to check if you are able to automate a test of a given website,
 but we'd like you to also demonstrate the coding quality, structure, and style of the deliverables.
 */

    ProductPage productPage = new ProductPage();

    @Test
    public void amazon() throws InterruptedException {
        searchForHat();
        selectHat();
        changeQuantity("firstSelectedQty");
        addToCart();
        goToCart();
        Verify_QtyAndPrice("firstSelectedQty");
        changeQuantity("changedQty");
        Verify_QtyAndPrice("changedQty");

    }


    public void searchForHat() {

        productPage.searchInputBox.sendKeys(ConfigurationReader.get("productHat"));
        productPage.searchButton.click();

    }

    public void selectHat() {
        productPage.aHat.click();
    }

    public void changeQuantity(String quantity) {
        select = new Select(productPage.dropDownOfQty);
        select.selectByVisibleText(ConfigurationReader.get(quantity));
    }

    public void addToCart() {
        productPage.addToCartButton.click();
    }

    public void goToCart() {
        productPage.Cart.click();
    }

    public void Verify_QtyAndPrice(String quantity) {
        String qty = productPage.qtyOnCartPage.getText();

        int actual_qty = Integer.parseInt(qty);
        System.out.println(actual_qty);
        Assert.assertEquals(qty,ConfigurationReader.get(quantity));


        String hatPrice = productPage.priceOfHat.getText();
        hatPrice = hatPrice.substring(1);

        double actualOneHatPrice = Double.parseDouble(hatPrice);
        System.out.println(actualOneHatPrice);

        double totalPriceOfHat = actual_qty * actualOneHatPrice;
        String expectedTotalPriceOfHat= Double.toString(totalPriceOfHat);

        String totalPrice = productPage.totalPrice.getText();
        totalPrice = totalPrice.substring(1);
        double actualTotalPrice = Double.parseDouble(totalPrice);
        System.out.println(actualTotalPrice);

        Assert.assertEquals(totalPrice, expectedTotalPriceOfHat);


    }




}
