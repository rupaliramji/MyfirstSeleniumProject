package com.mystoretestcase;
import com.mystorepageobject.AccountCreationPage;
import com.mystorepageobject.UserAccountPage;
import com.mystorepageobject.indexPage;
import com.mystorepageobject.myAccount;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class Tc_MyAccountPageTest extends BaseClass{
    @Test

    public void createAnAccount() throws InterruptedException {
        indexPage Ipage=new indexPage(driver);
        Ipage.clickOnSignIn();
        Thread.sleep(1000);
        //enter email address
        String Email=read.getEmail();
        //create object of myAccount Class
        myAccount act=new myAccount(driver);
        act.enterCreateEmailAddress(Email);
        logger.info("entered email address");
        act.clickSubmitCreate();
        logger.info("clicked on submit button");
        String AccountTitle=driver.getTitle();
        System.out.println(AccountTitle);
        Assert.assertEquals(AccountTitle,"Login - My Shop");
        logger.info("Account creation page has opened");

    }
    @Test(dependsOnMethods = {"createAnAccount"})
    public void enterInfo() throws InterruptedException
    {
        AccountCreationPage Acc=new AccountCreationPage(driver);
        Thread.sleep(1000);
        Acc.selectGender1();
        Acc.EnterName();
        logger.info("Entered Name and Lastname");
        Acc.EnterPass();
        logger.info("Entered password");
        //Acc.DateOfBirth();
        Acc.clickRegister();
        Thread.sleep(1000);
        String Title=driver.getTitle();

        //verify user is created or not
        //created object of UserAccountPage
        UserAccountPage Useracc=new UserAccountPage(driver);
        String Uname=Useracc.getUserName();
        Assert.assertEquals(Uname,"Roop M");
        logger.info("verified user is created ");


    }





}













