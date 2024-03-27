package com.mystoretestcase;

import com.mystorepageobject.*;
import org.apache.poi.ss.formula.functions.T;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Tc_ProductAddToCart extends Tc_SearchProduct{
@Test (dependsOnMethods = {"searchProduct"})
    public void AddProductToCart() throws IOException, InterruptedException {

        ProductPage pp=new ProductPage(driver);
        Thread.sleep(1000);
        pp.selectSize("M");
        Thread.sleep(1000);
        pp.selectColor();
        Thread.sleep(2000);
        pp.clickAddToCart();
        logger.info("clicked AddToCart Button");
        screenShot(driver,"AddToCart");
        Boolean result=pp.verifyAddToCart();
        screenShot(driver,"AddToCart");
        Assert.assertTrue(result);
        screenShot(driver,"AddToCart");
        pp.clickCheckOut();
        logger.info("clicked to Proceed to Checkout");
    }





}
