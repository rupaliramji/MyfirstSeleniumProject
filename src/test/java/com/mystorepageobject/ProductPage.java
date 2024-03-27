package com.mystorepageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
    WebDriver Ldriver;

    //constructor
    public ProductPage(WebDriver rdriver) {
        Ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath="//select[@name='group_1']")
    WebElement size;

    @FindBy(xpath="//ul[@id=\"color_to_pick_list\"]//li//a[@name=\"Blue\"]")
    WebElement color;

    @FindBy(name = "Submit")
    WebElement AddToCart;

    @FindBy(xpath="//a[@title=\"Proceed to checkout\"]")
    WebElement ProceedToCheckout;

    @FindBy(xpath="//div[@id=\"layer_cart\"]//h2/i")
   WebElement CheckMessage;

    public void selectSize(String sizetype) {
        Select sc=new Select(size);
        sc.selectByVisibleText(sizetype);}
    public void selectColor(){
        color.click();
    }
    public void clickAddToCart()
    {
        AddToCart.click();
    }
    public void clickCheckOut()
    {
        ProceedToCheckout.click();
    }
    public Boolean verifyAddToCart() throws InterruptedException {
        Thread.sleep(1000);
        Boolean result=CheckMessage.isDisplayed();
        return result;
    }

}