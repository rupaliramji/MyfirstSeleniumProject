package com.mystoretestcase;

import com.mystorepageobject.SearchProductDisplayPage;
import com.mystorepageobject.UserAccountPage;
import com.mystorepageobject.indexPage;
import com.mystorepageobject.myAccount;
import org.testng.Assert;
import org.testng.annotations.*;


import java.io.IOException;

public class Tc_SearchProduct extends BaseClass{
    @Test
    public void searchProduct() throws IOException, InterruptedException {
        String searchKey="T-shirts";
        indexPage Ipage=new indexPage(driver);
        Ipage.clickOnSignIn();
        logger.info("clicked on SignIn button");
        myAccount macc=new myAccount(driver);
        macc.enterRegisteredEmail("Advaith@test.com");
        macc.enterRegisteredPassword("123456");
        logger.info("Entered Email and Password ");
        macc.clickSubmitLogin();
        logger.info("Clicked on Submit Button");
        UserAccountPage Uaccount=new UserAccountPage(driver);
        Uaccount.enterProductInSearchBox(searchKey);
        logger.info("searched for T-shirts");
        Uaccount.ClickOnSearchButton();
        SearchProductDisplayPage searchProduct=new SearchProductDisplayPage(driver);
        String productName=searchProduct.getProductText();
        System.out.println(productName);
        if(productName.contains(searchKey)){
            Thread.sleep(1000);
            searchProduct.clickProductText();
            Assert.assertTrue(true);
            logger.info("Search Product test is passed");
        }
        else{
            Assert.assertTrue(false);
            logger.info("Search product test is failed");
            screenShot(driver,"searchProduct");

        }



    }










}
