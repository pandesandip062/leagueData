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

import java.time.Duration;


public class ImplicitWaitActions {

    private Logger logger = LogManager.getLogger(ImplicitWaitActions.class);
    public void setimplicitWait(){

        try {
            DriverFactory.getInstance().getDriver().manage().timeouts().
                    implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
            logger.info("Implict wait time is set to" + Constants.IMPLICIT_WAIT_TIME);
        } catch (Exception e) {
            logger.error("Error occured while setting the implicit wait"+e.getMessage());
            ExtentFactory.getInstance().failTest("Error occured while setting the implicit wait"+e.getMessage());
        }
    }
}
