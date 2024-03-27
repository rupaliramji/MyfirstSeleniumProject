package com.mystorepageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class addressPage {

    WebDriver Ldriver;
    //constructor
    public addressPage(WebDriver rdriver)
    {
        Ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }
    @FindBy(linkText = "Proceed to checkout")
    WebElement checkout;
    @FindBy(id="address1")
    WebElement address1;

    @FindBy(id="city")
    WebElement city;

    @FindBy(xpath="//select[@id='id_state']")
    WebElement state;

    @FindBy(id="postcode")
    WebElement postcode;

    @FindBy(id="phone")
    WebElement phone;

    @FindBy(id="phone_mobile")
    WebElement mobileNo;

    @FindBy(id="alias")
    WebElement addTitle;

    @FindBy(xpath="//button[@name=\"submitAddress\"]")
    WebElement save;

public void EnterAdd(String add){
    address1.sendKeys(add);

}
public void Check()
{
    checkout.click();
}
public void EnterCity(String City){
    city.sendKeys(City);
}
public void SelectState(String Text)
{
        Select sc=new Select(state);
        sc.selectByVisibleText(Text);
    }

    public void EnterPostCode(String Code){
        postcode.sendKeys(Code);
    }
    public void EnterPhone(String Number){
        phone.sendKeys(Number);}
    public void EnterMobilePhone(String  MNumber){
        mobileNo.sendKeys(MNumber);}
    public void EnterAddTitle(String AddTitle){
        addTitle.sendKeys(AddTitle);}

    public void clickSave(){
    save.click();
    }







}
