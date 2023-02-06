package com.nopcommerce.pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends CommonAPI {
    public CheckoutPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    Logger log = LogManager.getLogger(CheckoutPage.class.getName());

}
