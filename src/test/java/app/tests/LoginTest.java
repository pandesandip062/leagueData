/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package app.tests;

import app.Pages.LoginPage;
import app.base.BaseTest;
import app.driver.ScreenShot;
import app.properties.TestDataLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest {


    @Test
    public void loginWithValidateUserNameAndValidPassword() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.loginApplication(TestDataLoader.getInstance().getUsername(), TestDataLoader.getInstance().getPassword());






    }
}
