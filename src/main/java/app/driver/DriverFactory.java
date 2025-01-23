/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package app.driver;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    private DriverFactory(){

    }

    @Getter
    private static DriverFactory instance = new DriverFactory();


    public void setDriver(WebDriver driverObj){
        driver.set(driverObj);
    }
    public WebDriver getDriver(){
        return driver.get();
    }

}
