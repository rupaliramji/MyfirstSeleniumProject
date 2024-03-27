package com.mystorepageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class AccountCreationPage {

    WebDriver Ldriver;

    //constructor
    public AccountCreationPage(WebDriver rdriver)
    {
        Ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(id = "id_gender1")
    WebElement Mr;
    @FindBy(id = "id_gender2")
    WebElement Mrs;

    @FindBy(xpath = " //input[@id=\"customer_firstname\"]")
    WebElement FirstName;

    @FindBy (xpath= "//input[@id=\"customer_lastname\"]")
    WebElement LastName;

    @FindBy(id = "passwd")
    WebElement PassWord;
    @FindBy(id = "days")
    WebElement days;

    @FindBy(id = "months")
    WebElement Month;

    @FindBy(id = "years")
    WebElement years;

    @FindBy(id = "newsletter")
    WebElement Checkbox;

    @FindBy(id = "submitAccount")
    WebElement Register;

    public void selectGender1() throws InterruptedException {
        Thread.sleep(1000);
        Mr.click();
    }

    public void selectGender2() throws InterruptedException {
        Thread.sleep(1000);
        Mrs.click();
    }

    public void EnterName() throws InterruptedException {
        Thread.sleep(1000);
        FirstName.sendKeys("Roop");
        Thread.sleep(1000);
        LastName.sendKeys("M");
    }

    public void EnterPass() {
        PassWord.sendKeys("abc@123");
    }


    public void DateOfBirth() {
        Select sc = new Select(days);
        sc.selectByIndex(10);
        Select sc1 = new Select(Month);
        sc1.selectByVisibleText("May");
        Select sc2= new Select(years);
        sc2.selectByValue("1990");
    }

    public void clickRegister()
    {

        Register.click();

    }


}



