/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package app.alert;


import app.driver.DriverFactory;
import app.report.ExtentFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

public class AlertActions {

    private Logger logger = LogManager.getLogger(AlertActions.class);

    private Alert alert;

    public void switchToAlert(){
        try{
            alert= DriverFactory.getInstance().getDriver().switchTo().alert();
            logger.info("Switched to alert");
            ExtentFactory.getInstance().passTest("Switched to alert");
        }catch (NoAlertPresentException e){
            logger.info("Exception occured while switching to alert");
            ExtentFactory.getInstance().failTest("Exception occured while switching to alert");
        }
    }

    public void acceptAlert(){
        try{
            this.alert.accept();
            logger.info("clicked on Ok button");
            ExtentFactory.getInstance().passTest("Clicked on ok button");
        }catch (Exception e){
            logger.info("Exception occured while clicking on ok button");
            ExtentFactory.getInstance().failTest("Exception occured while clicking on ok button");
        }
    }

    public void cancelAlert(){
        try{
            this.alert.dismiss();
            logger.info("clicked on cancel button");
            ExtentFactory.getInstance().passTest("Clicked on cancel button");
        }catch (Exception e){
            logger.info("Exception occured while clicking on cancel button");
            ExtentFactory.getInstance().failTest("Exception occured while clicking on cancel button");
        }
    }
}
