package com.mystoretestcase;

import com.mystorepageobject.ProductPage;
import com.mystorepageobject.addressPage;
import com.mystorepageobject.paymentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.logging.Logger;

public class Tc_paymentPage extends Tc_ProductAddToCart  {

    @Test(dependsOnMethods= {"searchProduct","AddProductToCart"})
    public void paymentMethod() throws IOException {
        addressPage Ap=new addressPage(driver);
        Ap.Check();
       /* Ap.EnterAdd("Edgewater Blvd");
        Ap.EnterCity("Redwood");
        Ap.SelectState("California");
        Ap.EnterPostCode("94405");
        Ap.EnterPhone("456123789");
        Ap.EnterMobilePhone("456123789");
        Ap.EnterAddTitle("My Address");
        Ap.clickSave();
        screenShot(driver,"addresspage");
        logger.info("entered the required field of address");*/
        paymentPage Pp=new paymentPage(driver);
        logger.info("create an object of Payment page");
        Pp.click();
        Pp.CheckCheckBox();
        Pp.ProceedToCheck();
        Pp.Payment();
        Pp.ConfirmOrder();
        String Message= Pp.ConfirmationMessage();
        logger.info("get confirmation message");
        Assert.assertEquals(Message,"Your order on My Shop is complete.");







    }
}
