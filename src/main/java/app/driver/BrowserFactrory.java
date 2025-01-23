/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package app.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactrory {

    public static WebDriver createBrowserInstance(String browserName){
        WebDriver driver=null;
        if(browserName.equalsIgnoreCase("Chrome")){
            driver= new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driver= new EdgeDriver();

        }else if(browserName.equalsIgnoreCase("Firefox")){
            driver= new FirefoxDriver();
        }

        return driver;
    }

}
