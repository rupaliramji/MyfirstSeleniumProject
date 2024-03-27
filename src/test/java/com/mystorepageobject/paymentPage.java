package com.mystorepageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class paymentPage {

    WebDriver Ldriver;

    //constructor
    public paymentPage(WebDriver rdriver)
    {
        Ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    @FindBy(xpath="//button[@name=\"processAddress\"]")
    WebElement proceed;

    @FindBy(xpath="//input[@id=\"cgv\"]")
    WebElement checkBox;

    @FindBy(xpath = "//*[@name=\"processCarrier\"]")
    WebElement proceedToCheckout;

    @FindBy(xpath = "//a[@class=\"cheque\"]")
    WebElement pay;

    @FindBy(xpath="//*[@class=\"button btn btn-default button-medium\"]")
    WebElement confirmOrder;

    @FindBy(xpath ="//p[contains(text(),'Your order on My Shop is complete.')]")
    WebElement ConfirmMessage;

    public void click(){
        proceed.click();
    }
    public void CheckCheckBox(){
        checkBox.click();
    }
    public  void ProceedToCheck(){
        proceedToCheckout.click();
    }
    public  void Payment(){
        pay.click();
    }
    public  void ConfirmOrder(){
        confirmOrder.click();
    }
    public  String ConfirmationMessage(){
        return ConfirmMessage.getText();
    }


}
