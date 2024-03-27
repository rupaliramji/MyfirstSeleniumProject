package com.mystorepageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccount {


    WebDriver Ldriver;
    //constructor
    public myAccount(WebDriver rdriver)
    {
        Ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }

//identify elements to create account
     @FindBy(id="email_create")
     WebElement createEmailId;

     @FindBy(id="SubmitCreate")
     WebElement  SubmitCreate;
//identify elements to register account
     @FindBy(id="email")
     WebElement RegisteredEmail;

     @FindBy(id="passwd")
     WebElement RegisteredPassWord;

     @FindBy(id="SubmitLogin")
     WebElement submitLogin;
  //method for account creation
     public void enterCreateEmailAddress(String emailAdd)
     {
         createEmailId.sendKeys(emailAdd);
     }
     public void clickSubmitCreate() {
         SubmitCreate.click();
     }
  //method for registered account
    public void enterRegisteredEmail(String email)
    {

         RegisteredEmail.sendKeys(email);
    }

    public void enterRegisteredPassword(String pwd)
    {
         RegisteredPassWord.sendKeys(pwd);
    }
    public void clickSubmitLogin(){
         submitLogin.click();
    }
}
