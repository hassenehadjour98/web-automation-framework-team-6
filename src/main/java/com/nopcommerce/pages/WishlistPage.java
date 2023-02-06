package com.nopcommerce.pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage extends CommonAPI {
    public WishlistPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    Logger log = LogManager.getLogger(WishlistPage.class.getName());
    @FindBy(css = ".product-name")
    WebElement productName;

    public String getWishlistProductName(){
        return getTextFromElement(productName);
    }
}
