/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package app.iframe;

import app.constants.Constants;
import app.driver.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;


public class IframeActions {

    private Logger logger = LogManager.getLogger(IframeActions.class);

    public void waitForInframeAndSwitchFrame(String idorName) throws IOException {

        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));

            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(idorName));

            logger.info("Switched to iframe");
        //    ExtentFactory.passTest("switched to iframe");
        } catch (Exception e) {
            logger.error("Error occurted while switching frame");
        //    ExtentFactory.failTest("Error occured while switching iFrame");
        }

    }

    public void waitForIframeAndSwitch(int index) throws IOException {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));

            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));

            logger.info("Switched to iframe");
        //    ExtentFactory.passTest("switched to iframe");
        } catch (Exception e) {
            logger.error("Error occurted while switching frame");
         //   ExtentFactory.failTest("Error occured while switching iFrame");
        }
    }

    public void switchToDefaultFrame() throws IOException {

        try{
        DriverFactory.getInstance().getDriver().switchTo().defaultContent();
        logger.info("Switched to defaultFrame");
//        ExtentFactory.passTest("switched to defaultFrame");
    } catch (Exception e) {
        logger.error("Error occurted while switching defaultFrame");
     //   ExtentFactory.failTest("Error occured while switching defaultFrame");
    }
    }
}
