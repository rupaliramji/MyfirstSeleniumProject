package com.mystoretestcase;

import com.beust.ah.A;
import com.mystorepageobject.UserAccountPage;
import com.mystorepageobject.indexPage;
import com.mystorepageobject.myAccount;
import com.mystoreutilities.ReadExcelFile;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.logging.Logger;

import static com.mystoreutilities.ReadExcelFile.workBook;

public class Tc_RegisteredAccountDataDriven extends BaseClass {
    @Test(dataProvider="LoginData")
    public void registeredAccount(String Email,String Pwd,String exp) throws IOException, InterruptedException {
        indexPage Ipage = new indexPage(driver);
        Ipage.clickOnSignIn();
        myAccount act = new myAccount(driver);
        act.enterRegisteredEmail(Email);
        logger.info("entered registered email id");
        act.enterRegisteredPassword(Pwd);
        logger.info("entered registered password ");
        act.clickSubmitLogin();
        logger.info("clicked on submit button");
        Thread.sleep(1000);
        UserAccountPage up = new UserAccountPage(driver);
        String Euname="Suman P";
        if (exp.equals("Valid")) {
            if(Euname.equals(up.getUserName())){
                up.Logout();
                Assert.assertTrue(true);
                logger.info("User registration with Valid email and Password is pass");
            }else{
                Assert.assertTrue(false);
                logger.info("Registration with Valid email and Password is Fail");
                screenShot(driver,"RegisteredAccount");
            }
        }

        else if(exp.equals("Invalid")){
            if(driver.findElement(By.xpath("//li[contains(text(),'Authentication failed.')]")).isDisplayed()){
                Assert.assertTrue(true);
                logger.info("Registration with Invalid email and Password is Fail Hence test is passed");
            }
            else /*if(warning.equals("Authentication failed"))*/{
                Assert.assertTrue(false);

            }

        }


    }

   @DataProvider(name="LoginData")
    public String[][] getData() throws IOException {
        //get data from Excel
        String filename="/Users/rupaliramji/IdeaProjects/rupali/MyFirstProject/Testdata/MyStore.xlsx";
        int ttlRow = ReadExcelFile.getRowCount(filename, "RegisteredEmail");
        int ttlColumn = ReadExcelFile.getCellCount(filename, "RegisteredEmail");
        String[][] getData= new String[ttlRow][ttlColumn];
        for (int i = 1; i <=ttlRow; i++) {
            for (int j = 0; j < ttlColumn; j++) {
                getData[i - 1][j] = ReadExcelFile.getCellValue(filename,"RegisteredEmail",i,j);;
            }
        }

        return getData;



    }
}