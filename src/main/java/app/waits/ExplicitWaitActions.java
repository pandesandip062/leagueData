/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package app.waits;


import app.constants.Constants;
import app.driver.DriverFactory;
import app.report.ExtentFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitActions {

    private Logger logger = LogManager.getLogger(ExplicitWaitActions.class);

    public void waitForElementToBePresent(WebElement element,String elmentName){

        try {

            WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),
                    Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
            wait.until(ExpectedConditions.visibilityOf(element));
            logger.info(elmentName + " is available on screen");
            ExtentFactory.getInstance().passTest(element+"is avaliable on screen");
        }catch (Exception e){
            logger.error("Exception occured while waiting to visible "+e.getMessage());
            ExtentFactory.getInstance().failTest("Exception occured while waiting to visible "+e.getMessage());
        }

    }

    public void waitForElementToClickable(WebElement element,String elmentName){

        try {

            WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
            wait.until(ExpectedConditions.elementToBeClickable(element));

            logger.info(elmentName + " is clickable on screen");
        }catch (Exception e){
            logger.error("Exception occured while waiting to click the element "+e.getMessage());
            ExtentFactory.getInstance().failTest("Exception occured while waiting to click the element "+e.getMessage());

        }

    }
}
