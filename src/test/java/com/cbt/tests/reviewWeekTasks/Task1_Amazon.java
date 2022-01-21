package com.cbt.tests.reviewWeekTasks;

import com.cbt.pages.amazonPages.ProductPage;
import com.cbt.tests.TestBase;
import com.cbt.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task1_Amazon extends TestBase {
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
        selectAndAddHat();
        goToCartAndVerify_QtyAndPrice();
        reduceQuantity();
        verifyChanged_QtyAndPrice();





    }


     public void searchForHat() throws InterruptedException {
        driver.get(ConfigurationReader.get("url1"));
        productPage.searchInputBox.sendKeys(ConfigurationReader.get("productHat"));
        productPage.searchButton.click();
        Thread.sleep(2000);
    }

    public void selectAndAddHat() throws InterruptedException {
        productPage.aHat.click();
        Thread.sleep(3000);
        select= new Select(productPage.dropDownOfQty);
        Thread.sleep(2000);
        select.selectByVisibleText("2");
        productPage.addToCartButton.click();
    }

    public void goToCartAndVerify_QtyAndPrice(){
        productPage.Cart.click();
        String actual_qty= productPage.selectedHatOfQuantity.getText();
        int qty2= Integer.parseInt(actual_qty);
        System.out.println(qty2);
        Assert.assertEquals(actual_qty,"2", "verify that qty:2");

        String hatPrice= productPage.priceOfHat.getText();
        hatPrice= hatPrice.substring(1);
        double actualOneHatPrice= Double.parseDouble(hatPrice);
        System.out.println(actualOneHatPrice);

        double expectedPriceOfTwoHat= qty2*actualOneHatPrice;

        String totalPrice=productPage.totalPrice.getText();
        totalPrice=totalPrice.substring(1);
        double actualTotalPrice= Double.parseDouble(totalPrice);
        Assert.assertEquals(actualTotalPrice,expectedPriceOfTwoHat);
        System.out.println(actualTotalPrice);
    }

    public void reduceQuantity() throws InterruptedException {
        select= new Select(productPage.dropDownOfQty);
        Thread.sleep(2000);
        select.selectByVisibleText("1");
    }

    public void verifyChanged_QtyAndPrice(){
        String actual_qty= productPage.qtyOnCartPage.getText();
        String[] qty= actual_qty.split(" ");
        qty[1]=qty[1].substring(1,2);
        int qty1= Integer.parseInt(qty[1]);
        System.out.println(qty1);
        Assert.assertEquals(qty1,"1", "verify that qty:1");

    }




}
