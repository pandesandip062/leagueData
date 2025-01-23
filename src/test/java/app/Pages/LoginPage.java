/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package app.Pages;

import app.base.BasePage;
import app.driver.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(name = "username")
    private WebElement useNameTextBox;

    @FindBy(xpath = "//input[@name=\"password\"]")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement loginBtn;

    public LoginPage(){
        PageFactory.initElements(DriverFactory.getInstance().getDriver(),this);
    }

    public void loginApplication(String userNamevalue,String passwordValue){
        super.sendKeys(useNameTextBox,"user name text box",userNamevalue);
        super.sendKeys(passwordTextBox,"Password text box",passwordValue);
        super.click(loginBtn,"login button");
    }

}
