/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package app.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static app.report.ExtentFactory.getInstance;

public class ExtentReportListner implements ITestListener {
    private static Logger logger = LogManager.getLogger(ExtentReportListner.class);
    private ExtentReports extentReports;
    private ExtentTest extentTest;

    @Override
    public void onTestStart(ITestResult result) {
        this.extentTest = extentReports.createTest(result.getName());
        getInstance().setExtent(extentTest);  // Set the extentTest here
        logger.info("Test is added to pool: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
       getInstance().passTest(result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
       getInstance().getExtentTest().fail("Exception details "+result.getThrowable().getMessage());
       ExtentFactory.failTest(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        getInstance().getExtentTest().log(Status.SKIP,"test case"+result.getName()+"is skipped");
    }

    @Override
    public void onStart(ITestContext context) {
        this.extentReports = ExtentReportManager.setUpExtentReport();  // Ensure this sets up the ExtentReports instance
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extentReports != null) {
            extentReports.flush();  // Ensure reports are flushed after tests
        }
    }
}
