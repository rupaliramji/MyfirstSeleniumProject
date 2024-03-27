package com.mystorepageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.mystoretestcase.BaseClass.driver;

public class UserAccountPage {

    WebDriver Ldriver;

    public UserAccountPage(WebDriver rdriver)
    {
        Ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    //locate Element

    @FindBy(xpath="//a[@class='account']")
    WebElement UserName;

    @FindBy(xpath = "//a[@class=\"logout\"]")
    WebElement Signout;

    @FindBy(name = "search_query")
    WebElement searchBox;

    @FindBy(name="submit_search")
    WebElement submit_Search;

    public String getUserName()
    {
        String Name=UserName.getText();
        return Name;
    }

    public void Logout(){
        Signout.click();
    }
    public void enterProductInSearchBox(String searchKey){
        searchBox.sendKeys(searchKey);
    }
    public SearchProductDisplayPage ClickOnSearchButton(){
        submit_Search.click();
        return new SearchProductDisplayPage(driver);
    }
    }


