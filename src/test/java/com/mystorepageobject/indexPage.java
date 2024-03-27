package com.mystorepageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {
    WebDriver Ldriver;
    //constructor
    public indexPage(WebDriver rdriver)
    {
        Ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }


    /*identify element*/
    @FindBy(linkText = "Sign in")
    WebElement signIn;

    public void clickOnSignIn(){
        signIn.click();
    }
}
