
/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package app.base;

import app.driver.BrowserFactrory;
import app.driver.DriverFactory;
import app.properties.ConfigLoadeer;
import app.properties.TestDataLoader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void setUp(){
        WebDriver driver = BrowserFactrory.createBrowserInstance(ConfigLoadeer.getInstance().getPropertyValue("browser"));
        DriverFactory.getInstance().setDriver(driver);

        DriverFactory.getInstance().getDriver().get(TestDataLoader.getInstance().getAppUrl());

    }

    @AfterSuite
    public void tearDown(){
        DriverFactory.getInstance().getDriver().quit();
    }
}
