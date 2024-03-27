package com.mystorepageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.mystoretestcase.BaseClass.driver;

public class SearchProductDisplayPage {
    WebDriver Ldriver;


        public SearchProductDisplayPage(WebDriver rdriver)
        {
            Ldriver=rdriver;
            PageFactory.initElements(rdriver,this);
        }


    @FindBy(xpath ="//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]")
    WebElement SearchProductText;

    public String getProductText(){

        return(SearchProductText.getText());
    }

    public ProductPage clickProductText()  {
        SearchProductText.click();
        return new ProductPage(driver);
    }
}
