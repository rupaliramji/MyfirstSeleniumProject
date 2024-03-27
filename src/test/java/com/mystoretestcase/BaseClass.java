package com.mystoretestcase;

import com.mystoreutilities.readConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseClass
{
    readConfig read=new readConfig();
   String url= read.getBaseUrl();
   String Browser=read.getBrowser();
   public static WebDriver driver;
   public static Logger logger;

   @BeforeClass
   public void setup() throws InterruptedException {
       switch (Browser) {
           case "chrome" -> {
               WebDriverManager.chromedriver().setup();
               driver = new ChromeDriver();
               Thread.sleep(1000);
           }
           case "firefox" -> {
               WebDriverManager.firefoxdriver().setup();
               driver = new FirefoxDriver();
           }
           case "safari" -> {
               WebDriverManager.safaridriver().setup();
               driver = new SafariDriver();
           }
           default -> driver = null;
       }

             driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
   //for logging

             logger= LogManager.getLogger("MyFirstProject");
             driver.get(url);
             logger.info("url open");

   }

        public void screenShot(WebDriver driver,String testName) throws IOException
        {
        File F = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path=System.getProperty("user.dir")+"//Screenshot//"+testName+".jpeg";
         FileUtils.copyFile(F,new File(path));


   }
    @AfterClass
    public void teardown()
        {
            driver.quit();
        }



}
