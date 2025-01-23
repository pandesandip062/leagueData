/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package app.report;


import app.driver.DriverFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class ExtentFactory {

    ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();

    private ExtentFactory() {

    }

    private static ExtentFactory instance = new ExtentFactory();

    public static ExtentFactory getInstance() {
        return instance;
    }

    public void setExtent(ExtentTest obj) {
        extent.set(obj);
    }
    public ExtentTest getExtentTest(){
        return extent.get();
    }

    public void removeTest() {
        extent.remove();
    }
    //ScreenShot method

    public static String captureApplicationScreenshot() {
        TakesScreenshot screenshot = (TakesScreenshot) DriverFactory.getInstance().getDriver();
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        byte[] fileContent = null;

        try {
            fileContent = FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Base64.getEncoder().encodeToString(fileContent);
    }

    public static void clickPass(String btnName){
        getInstance().getExtentTest().pass(btnName+" button is clicked");
    }

    public static void clickFail(String btnName){
        getInstance().getExtentTest().fail("Error occured while clicking on "+btnName);
    }

    public static void sendKeysPass(String value,String elementName){
        getInstance().getExtentTest().pass(value+" is entered in "+elementName);
    }
    public static void sendKeysFail(String value,String elementName){
        getInstance().getExtentTest().fail("error occured while entering value"+value+"in the text box"+elementName);
    }

    public static void passTest(String message){
        getInstance().getExtentTest().log(Status.PASS, MarkupHelper.createLabel(message, ExtentColor.GREEN));
    }

    public static void failTest(String message){
        ExtentTest extentTest = getInstance().getExtentTest();
        if (extentTest != null) {

            extentTest.fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(captureApplicationScreenshot()).build());
        } else {
            System.out.println("ExtentTest is null. Ensure that the ExtentTest is properly initialized before calling failTest.");
        }

    }

}
