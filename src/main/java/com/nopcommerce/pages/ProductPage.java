package com.nopcommerce.pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends CommonAPI {
    public ProductPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    Logger log = LogManager.getLogger(ProductPage.class.getName());
    @FindBy (xpath = "//div[@class='add-to-cart-panel']/input")
    WebElement txtProductQuantity;
    @FindBy (xpath = "//div[@class='add-to-wishlist']/button")
    WebElement btnAddToWishlist;
    @FindBy (xpath = "//div[@class='add-to-cart-panel']/button")
    WebElement btnAddToCart;
    @FindBy (css = "span.close")
    WebElement btnCloseNotification;



    public void enterNumberOfItems(int number){
        clearTextFromTextBox(txtProductQuantity);
        typeNumber(txtProductQuantity,number);
    }
    public void clickOnCloseNotification(){
        clickOn(btnCloseNotification);
    }
    public void addToWishlist(){
        clickOn(btnAddToWishlist);
    }
    public void addToCart(){
        clickOn(btnAddToCart);
    }

}
