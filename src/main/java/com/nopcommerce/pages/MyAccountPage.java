package com.nopcommerce.pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends CommonAPI {
    public MyAccountPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    Logger log = LogManager.getLogger(MyAccountPage.class.getName());
    @FindBy(css = ".ico-account")
    WebElement lnkMyAccount;
    @FindBy(css = ".ico-logout")
    WebElement lnkLogOut;

    public String getMyAccountLinkText(){
        return getTextFromElement(lnkMyAccount);
    }
    public void logOut(){
        clickOn(lnkLogOut);
    }


}
