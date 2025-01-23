/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package app.base;

import app.alert.AlertActions;

import app.iframe.IframeActions;
import app.javascript.JavaScriptActions;
import app.report.ExtentFactory;
import app.waits.ExplicitWaitActions;
import org.openqa.selenium.WebElement;

public class BasePage {


    protected IframeActions iframeActions;

    protected ExplicitWaitActions explicitWaitActions;
    protected AlertActions alertActions;
    protected JavaScriptActions javaScriptActions;

    protected BasePage(){
        alertActions= new AlertActions();
        iframeActions = new IframeActions();
        explicitWaitActions = new ExplicitWaitActions();
        javaScriptActions= new JavaScriptActions();
    }

    public void click(WebElement element,String elementname){
        explicitWaitActions.waitForElementToClickable(element,elementname);
        element.click();
        ExtentFactory.getInstance().passTest(elementname+ "is clicked");
    }

    public void sendKeys(WebElement element,String elementName,String value){
        explicitWaitActions.waitForElementToBePresent(element,elementName);
        element.clear();
        element.sendKeys(value);
        ExtentFactory.getInstance().passTest(value+" is entered in"+elementName);

    }


    public boolean isElementSelected(WebElement element,String elementName){
        explicitWaitActions.waitForElementToBePresent(element,elementName);
        ExtentFactory.getInstance().passTest("element is selected");
        return element.isSelected();

    }

    public void selectCheckBox(WebElement element,String elementName){
       if(this.isElementSelected(element,elementName)==false){
           this.click(element,elementName);
       }else {
           ExtentFactory.getInstance().failTest(elementName+" is already selected");
       }
    }
}
