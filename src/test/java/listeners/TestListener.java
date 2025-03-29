package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.logging.log4j.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utility.ScreenshotUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import java.util.logging.Logger;

public class TestListener implements ITestListener {

    private static final Logger logger = (Logger) LogManager.getLogger(TestListener.class);
    ExtentReports extent;
    private static WebDriver driver;
    ExtentTest test;

    @Override
    public void onStart(ITestContext context) {

        try {

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
            sparkReporter.config().setDocumentTitle("Automation Report");
            sparkReporter.config().setReportName("Test Report");
            sparkReporter.config().setTheme(Theme.STANDARD);

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Tester", "QA Engineer");

            logger.info("Extent Reports initialized");
        } catch (Exception e) {
            logger.info("Exception in onStart: {}");
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test Execution is Finished***************************************************");
        try {
            extent.flush(); // Write the report
            logger.info("Test Execution Finished and Extent Report generated.");
        } catch (Exception e) {
            logger.info("Exception in onFinish: {}");
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("#########Test case execution starts");

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("###############Test case passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

      //  ScreenshotUtility.getScreenShot(result.getTestName());

        try {

            test.log(Status.FAIL, "Test Failed: " + result.getName());
            logger.info("Test Failed: {}");

            // Capture screenshot and attach to report
            String screenshotPath = takeScreenshot(result.getName());
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            logger.info("Exception in onTestFailure: {}");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info("This Test Case is Skipped");
    }

    public static String takeScreenshot(String testName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = String.valueOf(new Date().getTime());
            String screenshotPath = "screenshots/" + testName + "_" + timestamp + ".png";

            FileHandler.copy(src, new File(screenshotPath));
            logger.info("Screenshot saved: {}");

            return screenshotPath;
        } catch (IOException e) {
            logger.info("Exception while capturing screenshot: {}");
            return null;
        }

    }
}
