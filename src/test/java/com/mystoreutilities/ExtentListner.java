package com.mystoreutilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestListener;
import org.testng.annotations.Test;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ExtentListner implements ITestListener {

    ExtentSparkReporter HtmlReporter;
    ExtentReports reports;
    ExtentTest Test;

    public void configReport() {
        readConfig read=new readConfig();
        String timestamp=new SimpleDateFormat("yyyy.MM.dd hh:mm:ss").format(new Date());
        String reportName="MyStoreReport-"+timestamp+".html";
        HtmlReporter = new ExtentSparkReporter(reportName);
        reports = new ExtentReports();
        reports.attachReporter(HtmlReporter);

        //add system information to the report
        reports.setSystemInfo("Machine", "macbook");
        reports.setSystemInfo("Os", "Macos");
        reports.setSystemInfo("browser", read.getBrowser());
        reports.setSystemInfo("username", "roop");

        //change look and feel of report
        HtmlReporter.config().setDocumentTitle("Extent report");
        HtmlReporter.config().setReportName("Mystore Report");
        HtmlReporter.config().setTheme(Theme.DARK);
    }


    @Test

        public void onTestSuccess (org.testng.ITestResult result){ System.out.println("Name of the test method Passed" + result.getName());
        Test = reports.createTest(result.getName());
        Test.log(Status.PASS, MarkupHelper.createLabel("Name of the Passes test method:" + result.getName(), ExtentColor.GREEN));
    }

        public void onTestFailure (org.testng.ITestResult result)
        {
            System.out.println("Name of the test method failed:" + result.getName());
            Test = reports.createTest(result.getName());
            Test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test method:" + result.getName(), ExtentColor.RED));
            String Screenshot=System.getProperty("user.dir")+"//Screenshot//"+result.getName()+".jpeg";
            File screenShotFile=new File(Screenshot);
            if(screenShotFile.exists())
            {
                Test.fail("captured screenshot is below:"+Test.addScreenCaptureFromPath(Screenshot));
            }
        }

        public void onTestSkipped (org.testng.ITestResult result) {
            System.out.println("Name of the test method Skipped:" + result.getName());
            Test = reports.createTest(result.getName());
            Test.log(Status.SKIP,MarkupHelper.createLabel("Name of the skipped test method"+result.getName(),ExtentColor.BLACK));
        }
        public void onTestFailedButWithinSuccessPercentage (org.testng.ITestResult result){ /* compiled code */ }

        public void onTestFailedWithTimeout (org.testng.ITestResult result){ /* compiled code */ }

        public void onStart (org.testng.ITestContext context )
        {
            configReport();
            System.out.println("On Start method invoked");
        }

        public void onFinish (org.testng.ITestContext context)
        {
            System.out.println("On Finished method invoked");
            reports.flush();
        }
    }





