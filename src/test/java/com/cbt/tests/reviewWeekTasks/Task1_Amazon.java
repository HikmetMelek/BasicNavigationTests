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
        goToCart();
        Verify_QtyAndPrice();
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
        select.selectByVisibleText(ConfigurationReader.get("firstSelectedQty"));
        productPage.addToCartButton.click();
    }

    public void goToCart(){
        productPage.Cart.click();

    }

    public void Verify_QtyAndPrice(){
        String qty= productPage.qtyOnCartPage.getText();
        String[] textOfQty= qty.split(" ");
        textOfQty[1]=textOfQty[1].substring(1,2);

        int actual_qty= Integer.parseInt(textOfQty[1]);
        System.out.println(actual_qty);

        Assert.assertEquals(textOfQty,ConfigurationReader.get("firstSelectedQty"), "verify that qty:2");

        String hatPrice= productPage.priceOfHat.getText();
        hatPrice= hatPrice.substring(1);

        double actualOneHatPrice= Double.parseDouble(hatPrice);
        System.out.println(actualOneHatPrice);

        double expectedPriceOfHat= actual_qty*actualOneHatPrice;

        String totalPrice=productPage.totalPrice.getText();
        totalPrice=totalPrice.substring(1);
        double actualTotalPrice= Double.parseDouble(totalPrice);

        Assert.assertEquals(actualTotalPrice,expectedPriceOfHat);
        System.out.println(actualTotalPrice);

    }

    public void reduceQuantity() throws InterruptedException {
        select= new Select(productPage.dropDownOfQty);
        Thread.sleep(2000);
        select.selectByVisibleText(ConfigurationReader.get("changedQty"));
    }

    public void verifyChanged_QtyAndPrice(){
        String qty= productPage.qtyOnCartPage.getText();
        String[] textOfQty= qty.split(" ");
        textOfQty[1]=textOfQty[1].substring(1,2);
        int actual_qty= Integer.parseInt(textOfQty[1]);
        System.out.println(actual_qty);
        Assert.assertEquals(textOfQty,ConfigurationReader.get("changedQty"), "verify that qty:1");

    }




}
