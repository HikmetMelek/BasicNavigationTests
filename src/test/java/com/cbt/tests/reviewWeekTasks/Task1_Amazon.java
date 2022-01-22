package com.cbt.tests.reviewWeekTasks;

import com.cbt.pages.amazonPages.ProductPage;
import com.cbt.tests.TestBase_Amazon;
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
        productPage.searchForHat();
        productPage.selectHat();
        productPage.changeQuantity("firstSelectedQty");
        productPage.addToCart();
        productPage.goToCart();
        productPage.Verify_QtyAndPrice("firstSelectedQty");
        productPage.changeQuantity("changedQty");
        productPage.Verify_QtyAndPrice("changedQty");

    }









}
